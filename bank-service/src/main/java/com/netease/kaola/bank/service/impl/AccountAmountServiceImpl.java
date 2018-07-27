package com.netease.kaola.bank.service.impl;

import com.netease.kaola.bank.service.api.AccountAmountService;
import com.netease.kaola.generic.api.bank.mapper.AccountAmountMapper;
import com.netease.kaola.generic.api.model.TransactionRecords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("accountAmountService")
public class AccountAmountServiceImpl implements AccountAmountService {
    @Resource
    private AccountAmountMapper accountAmountMapper;

    @Override
    public Integer updateAccountAmountRecordsPrepare(TransactionRecords transactionRecords) {
        return null;
    }

    @Override
    public Integer updateAccountAmountRecordsPrepareToConfirm(TransactionRecords transactionRecords) {
        return null;
    }

    @Override
    public Integer updateAccountAmountRecordsPrepareToCancel(TransactionRecords transactionRecords) {
        return null;
    }
}
