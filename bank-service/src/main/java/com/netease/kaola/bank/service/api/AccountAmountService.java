package com.netease.kaola.bank.service.api;

import com.netease.kaola.generic.api.model.TransactionRecords;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface AccountAmountService {
    /**
     * 更新为准备状态
     *
     * @param transactionRecords 用户事务记录
     */
    Integer updateAccountAmountRecordsPrepare(TransactionRecords transactionRecords);


    /**
     * 更新从预取状态到真实提交状态
     *
     * @param transactionRecords 事务记录
     */
    Integer updateAccountAmountRecordsPrepareToConfirm(TransactionRecords transactionRecords);


}
