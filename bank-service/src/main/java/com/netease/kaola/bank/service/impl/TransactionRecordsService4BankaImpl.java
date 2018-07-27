package com.netease.kaola.bank.service.impl;

import com.netease.kaola.bank.service.api.TransactionRecordsService;
import com.netease.kaola.generic.api.bank.mapper.TransactionRecordsMapper;
import com.netease.kaola.generic.api.model.TransactionRecords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("transactionRecordsService")
public class TransactionRecordsService4BankaImpl implements TransactionRecordsService {
    @Resource
    TransactionRecordsMapper transactionRecordsMapper;

    /**
     * 这里做持久化不会有并发问题，利用数据库的一致性约束
     *
     * @param transactionRecords 转账记录
     */
    @Override
    public Integer insertTransactionRecords(TransactionRecords transactionRecords) {
        return transactionRecordsMapper.insertTransactionRecords(transactionRecords);
    }

    @Override
    public TransactionRecords getTransactionRecordsByGorderId(Long id) {
        return null;
    }

    @Override
    public Integer updateTransactionRecords(TransactionRecords transactionRecords) {
        return null;
    }
}
