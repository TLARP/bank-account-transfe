package com.netease.kaola.bank.service.api;

import com.netease.kaola.generic.api.model.TransactionRecords;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface TransactionRecordsService {
    /**
     * 插入用户的转账初始记录
     *
     * @param transactionRecords 转账记录
     */
    Integer insertTransactionRecords(TransactionRecords transactionRecords);

    /**
     * 根据订单号查询信息
     */
    TransactionRecords getTransactionRecordsByGorderId(Long id);

    /**
     * 更新事务表状态字段
     *
     * @param transactionRecords 事务记录
     */
    Integer updateTransactionRecords(TransactionRecords transactionRecords);
}
