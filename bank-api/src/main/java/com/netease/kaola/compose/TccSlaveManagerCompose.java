package com.netease.kaola.compose;

import com.netease.kaola.model.TransactionRecordsVO;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface TccSlaveManagerCompose {

    /**
     * 锁定成功正确返回，锁定失败直接返回异常
     *
     * @param transactionRecordsVO 事务对象
     */
    Integer preGetAccountResouce(TransactionRecordsVO transactionRecordsVO);


    /**
     * 1）如果从事务方自己执行的过程中就发生了异常，那么直接自己回滚锁住的资源
     * 2）如果是由于网络超时的原因，那么需要由主事务方来触发回调操作，保证回调成功
     * 3）对于确认锁住的资源我们也可以加上自动超时机制，置顶时间没有确认，我们直设置为无效
     */
    Integer rollBackAccountResource(TransactionRecordsVO transactionRecordsVO);

    /**
     * 更新从预取状态到真实状态
     *
     * @param transactionRecords 事务记录
     */
    Integer updateAccountAmountRecordsPrepareToConfirm(TransactionRecordsVO transactionRecords);


    /**
     * 从确认回退到准备阶段
     *
     * @param transactionRecordsVO 事务记录
     */
    Integer updateAccountAmountRecordsPrepareToConfirmToCancel(TransactionRecordsVO transactionRecordsVO);
}
