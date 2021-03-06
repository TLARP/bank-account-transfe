package com.netease.kaola.generic.api.bank.mapper;

import com.netease.kaola.generic.api.model.AccountAmountRecords;
import com.netease.kaola.generic.api.model.OrderForm;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface AccountAmountMapper {

    /**
     * 根据用户获取账户记录
     *
     * @param accountAmountRecords 记录信息
     */
    AccountAmountRecords selectAccountAmountByAccountId(AccountAmountRecords accountAmountRecords);

    /**
     * 更新状态
     *
     * @param accountAmountRecords 用户事务记录
     */
    Integer updateAccountAmountRecordsPrepare(AccountAmountRecords accountAmountRecords);

    /**
     * 按交易金额暂时更新用户扣减余额
     *
     * @param orderForm 订单数据
     */
    Integer deductionAccountAmountRecords(OrderForm orderForm);

    /**
     * 按交易金额真实扣减
     *
     * @param orderForm 订单信息
     */
    Integer realDeductionAccountAmountRecords(OrderForm orderForm);
}
