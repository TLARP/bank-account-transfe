package com.netease.kaola.bank.service.impl;

import com.netease.kaola.bank.service.api.TransactionRecordsService4Banka;
import com.netease.kaola.generic.api.banka.mapper.TransactionRecordsMapper;
import com.netease.kaola.generic.api.model.TransactionRecords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("transactionRecordsService4Banka")
public class TransactionRecordsService4BankaImpl implements TransactionRecordsService4Banka {
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
}
