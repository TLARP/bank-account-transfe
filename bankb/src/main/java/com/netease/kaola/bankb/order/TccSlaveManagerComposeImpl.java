package com.netease.kaola.bankb.order;

import com.netease.kaola.bank.service.api.AccountAmountService;
import com.netease.kaola.bank.service.api.TransactionRecordsService;
import com.netease.kaola.compose.TccSlaveManagerCompose;
import com.netease.kaola.model.TransactionRecordsVO;
import org.omg.IOP.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("tccSlaveManagerCompose")
public class TccSlaveManagerComposeImpl implements TccSlaveManagerCompose {
    @Resource
    private TransactionRecordsService transactionRecordsService;

    @Resource
    private AccountAmountService accountAmountService;

    public Integer preGetAccountResouce(TransactionRecordsVO transactionRecordsVO) {
        return null;
    }

    public Integer rollBackAccountResource(TransactionRecordsVO transactionRecordsVO) {
        return null;
    }

    public Integer updateAccountAmountRecordsPrepareToConfirm(TransactionRecordsVO transactionRecords) {
        return null;
    }

    public Integer updateAccountAmountRecordsPrepareToConfirmToCancel(TransactionRecordsVO transactionRecordsVO) {
        return null;
    }
}
