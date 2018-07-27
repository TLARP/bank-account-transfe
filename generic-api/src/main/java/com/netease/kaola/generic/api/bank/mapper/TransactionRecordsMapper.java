package com.netease.kaola.generic.api.bank.mapper;

import com.netease.kaola.generic.api.model.TransactionRecords;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface TransactionRecordsMapper {

    /**
     * 插入记录
     *
     * @param transactionRecords 用户交易记录
     */
    Integer insertTransactionRecords(TransactionRecords transactionRecords);

    /**
     * 更新表单状态
     *
     * @param transactionRecords 用户交易记录
     */
    Integer updateTransactionRecords(TransactionRecords transactionRecords);

    /**
     * 根据订单号获取订单信息
     *
     * @param id 订单号
     */
    TransactionRecords getTransactionRecordsByGorderId(Long id);
}
