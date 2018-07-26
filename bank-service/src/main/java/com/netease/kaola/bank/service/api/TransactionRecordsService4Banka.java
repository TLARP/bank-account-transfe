package com.netease.kaola.bank.service.api;

import com.netease.kaola.generic.api.model.TransactionRecords;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface TransactionRecordsService4Banka {
    /**
     * 插入用户的转账初始记录
     *
     * @param transactionRecords 转账记录
     */
    Integer insertTransactionRecords(TransactionRecords transactionRecords);
}
