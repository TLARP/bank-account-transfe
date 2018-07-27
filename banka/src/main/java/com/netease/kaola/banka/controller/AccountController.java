package com.netease.kaola.banka.controller;

import com.netease.kaola.bank.service.api.AccountAmountService;
import com.netease.kaola.bank.service.api.TransactionRecordsService;
import com.netease.kaola.common.MapUtils;
import com.netease.kaola.compose.TccSlaveManagerCompose;
import com.netease.kaola.generic.api.exception.ConfrimException;
import com.netease.kaola.generic.api.exception.TryResouceException;
import com.netease.kaola.generic.api.model.StatusEnum;
import com.netease.kaola.generic.api.model.TransactionRecords;
import com.netease.kaola.model.TransactionRecordsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by hzwangqiqing
 * on 2018/7/26.
 */
@RequestMapping("/transfer")
@Controller
public class AccountController {
    @Resource
    private TransactionRecordsService transactionRecordsService;

    @Resource
    private AccountAmountService accountAmountService;

    @Resource
    private TccSlaveManagerCompose tccSlaveManagerCompose;


    /**
     * 1)账户都是从cookie取
     * 2)单点登录但是用户点击转账一下发了N次请求，用gorderId做幂等
     * 3)goderId可以用对称秘钥加密防止别人伪造这里省略了
     * 4)返回的信息不是直接toast用户
     */
    @RequestMapping("/getGorderId")
    @ResponseBody
    public Map<String, Object> getGorderId(String accountIdIn, String accountIdOut, BigDecimal amount) {
        TransactionRecords transactionRecords = new TransactionRecords();
        transactionRecords.setAccountIdIn(accountIdIn);
        transactionRecords.setAccountIdOut(accountIdOut);
        transactionRecords.setDeductionAmount(amount);
        transactionRecords.setTimestamp(new Timestamp(System.currentTimeMillis()));
        transactionRecords.setStatas(StatusEnum.TRY.getStatus());
        transactionRecordsService.insertTransactionRecords(transactionRecords);
        return MapUtils.mapWithSuccess(transactionRecords.getId());
    }

    /**
     * @param gorderId 订单号
     *                 <p>
     *                 这里加入就是转账操作，实际上支持邀请别人支付的场景也是可以做的
     */
    @RequestMapping("/transferMoney")
    @ResponseBody
    @Transactional
    public Map<String, Object> transferMoney(Long gorderId) {
        //TODO 订单号这里可以使用对称加密，否则有穿库的风险
        TransactionRecords transactionRecords = transactionRecordsService.getTransactionRecordsByGorderId(gorderId);
        if (transactionRecords == null) {
            return MapUtils.mapWithError("无效订单号，是否有攻击风险!");
        }
        //如果是非初始状态说明有任务在执行操作，这里直接忽略操作
        // TODO 这里对于单个用户的多次请求可以获取锁，普通账户的转账请求不影响客户体验
        if (!StatusEnum.TRY.getStatus().equals(transactionRecords.getStatas())) {
            return MapUtils.mapWithError("此次操作直接无效了!是不是有攻击风险!");
        }

        Integer num = accountAmountService.updateAccountAmountRecordsPrepare(transactionRecords);
        if (num == 0) {
            return MapUtils.mapWithError("锁定资源失败，现在可能不够转账了");
        }
        transactionRecords.setStatas(StatusEnum.TRY_SUCCCESS.getStatus());
        //这里如果触发数据库异常信息也会由于事务回滚，数据保持一致
        num = transactionRecordsService.updateTransactionRecords(transactionRecords);
        if (num == 0) {
            //事务回滚，不会导致数据不一致
            throw new TryResouceException();
        }
        //调用第三方的资源准备资源
        TransactionRecordsVO transactionRecordsVO = new TransactionRecordsVO();
        BeanUtils.copyProperties(transactionRecords, transactionRecordsVO);
        //这里如果第三方出现了异常
        try {
            tccSlaveManagerCompose.preGetAccountResouce(transactionRecordsVO);
        } catch (Exception e) {
            //fixme 这里为了减少复杂性我建议直接让从事务处理加一个默认超时机制
            tccSlaveManagerCompose.rollBackAccountResource(transactionRecordsVO);
            throw e;
        }
        //如果都准备成功，接下来直接进入确认状态,这里我感觉是不是
        num = accountAmountService.updateAccountAmountRecordsPrepareToConfirm(transactionRecords);
        if (num == 0) {
            throw new ConfrimException();
        }
        transactionRecords.setStatas(StatusEnum.CONFIRM.getStatus());
        num = transactionRecordsService.updateTransactionRecords(transactionRecords);
        if (num == 0) {
            throw new ConfrimException();
        }
        //从事务处理中心的状态修改为确认状态
        try {
            tccSlaveManagerCompose.updateAccountAmountRecordsPrepareToConfirm(transactionRecordsVO);
        } catch (Exception e) {
            //如果出现了异常我们就直接回滚，并通过异步任务去回调
            //TODO 但是这里可能有点问题，由于数据库的状态回到了最初状态请求可以继续，但是业务方有在执行回滚操作
            //TODO  ，因此就可能要我们选择如何处理这种场景是考虑用户体验直接废弃这次操作，还是说接下来用户可以继续付款，
            //TODO  如果可以用该订单号付款，那么回滚什么时间成功可能使我们又要解决的问题
            throw new ConfrimException();
        }
        return MapUtils.mapWithSuccess("转账成功!");
    }
}
