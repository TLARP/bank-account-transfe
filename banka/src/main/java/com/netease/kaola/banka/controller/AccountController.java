package com.netease.kaola.banka.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.common.collect.Maps;
import com.netease.kaola.bank.service.api.TransactionRecordsService4Banka;
import com.netease.kaola.common.MapUtils;
import com.netease.kaola.compose.OrderComposeApi;
import com.netease.kaola.compose.TccComposeApi;
import com.netease.kaola.generic.api.model.StatusEnum;
import com.netease.kaola.generic.api.model.TransactionRecords;
import com.netease.kaola.model.OrderFromVO;
import org.springframework.stereotype.Controller;
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
    @Resource(name = "tccComposeApiBankbImpl")
    private OrderComposeApi orderComposeApi;

    @Resource
    private TransactionRecordsService4Banka transactionRecordsService;

    @Resource(name = "tccComposeApiBankbImpl")
    private TccComposeApi tccComposeApi;

    /**
     * HTTP接口做测试
     */
    @RequestMapping("/getCurrentLoginAccount")
    @ResponseBody
    public Map<String, Object> getCurrentLoginAccount() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("retCode", 200);
        map.put("data", "q_test1@163.com");
        map.put("response", tccComposeApi.getTryMessage(new OrderFromVO()));
        return map;
    }

    /**
     * 1)账户都是从cookie取
     * 2)单点登录但是用户点击转账一下发了N次请求，用gorderId做幂等
     * 3)goderId可以用对称秘钥加密防止别人伪造这里省略了
     * 4)返回的信息不是直接toast用户
     */
    @RequestMapping("/getGorderId")
    @ResponseBody
    public Map<String, Object> getGorderId(String accountId) {
        if (StringUtils.isBlank(accountId)) {
            return MapUtils.mapWithError("账户未登录");
        }
        //转账金额大小等校验
        String gorderId;
        try {
            gorderId = orderComposeApi.getGorderId();
        } catch (Exception e) {
            return MapUtils.mapWithError("获取订单号失败!");
        }
        //这里应该不可能为null
        if (gorderId == null) {
            System.out.println("need send warning message! may be has bug!");
            return MapUtils.mapWithError("系统故障");
        }
        return MapUtils.mapWithSuccess(gorderId);
    }

    /**
     * @param accountIdOut 当前转出账户
     * @param amount       总金额
     * @param gorderId     订单号
     * @param accountIn    转入账户
     */
    @RequestMapping("/transferMoney")
    @ResponseBody
    public Map<String, Object> transferMoney(String accountIdOut, BigDecimal amount, String gorderId, String accountIn) {
        Timestamp serverTime = new Timestamp(System.currentTimeMillis());
        if (StringUtils.isBlank(accountIdOut) || amount == null || StringUtils.isBlank(gorderId)) {
            return MapUtils.mapWithError("请求参数有误!");
        }
        //插入用户订单表记录
        TransactionRecords transactionRecords = new TransactionRecords();
        transactionRecords.setAccountIdOut(accountIdOut);
        transactionRecords.setAccountIdIn(accountIn);
        transactionRecords.setDeductionAmount(amount);
        //设置为初始状态
        transactionRecords.setStatas(StatusEnum.TRY.getStatus());
        transactionRecords.setTimestamp(serverTime);
        transactionRecords.setGorderId(gorderId);
        try {
            transactionRecordsService.insertTransactionRecords(transactionRecords);
        } catch (Exception e) {
            return MapUtils.mapWithError("用户已经在转账忽略此次转账，或者是数据库连接有问题触发了异常，此次交易终止，如果是连接等问题，哨兵应该有报警！");
        }
        return MapUtils.mapWithSuccess("success!");
    }
}
