package com.netease.kaola.bank.service.impl;

import com.netease.kaola.bank.service.api.TccComposeApi4BankA;
import com.netease.kaola.generic.api.mapper.AccountAmountMapper;
import com.netease.kaola.generic.api.mapper.TransactionRecordsMapper;
import com.netease.kaola.generic.api.model.OrderForm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("tccComposeApi4BankA")
public class TccComposeApi4BankAImpl implements TccComposeApi4BankA {
    @Resource
    private TransactionRecordsMapper transactionRecordsMapper;

    @Resource
    private AccountAmountMapper accountAmountMapper;

    @Override
    public Integer getTryMessage(OrderForm orderFromVO) {
        return null;
    }

    @Override
    public Integer getConfirmMessage(OrderForm orderFromVO) {
        return null;
    }

    @Override
    public Integer execCancelOperation(OrderForm orderFromVO) {
        return null;
    }
}
