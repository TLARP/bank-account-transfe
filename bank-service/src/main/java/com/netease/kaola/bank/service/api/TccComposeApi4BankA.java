package com.netease.kaola.bank.service.api;

import com.netease.kaola.generic.api.model.OrderForm;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface TccComposeApi4BankA {
    /**
     * Response.error或者发生异常都认为是try-信息错误
     *
     * @param orderFromVO 订单详情
     */
    Integer getTryMessage(OrderForm orderFromVO);


    /**
     * 获取账户扣减操作的执行状态
     *
     * @param orderFromVO 订单详情
     */
    Integer getConfirmMessage(OrderForm orderFromVO);


    /**
     * 发生错误由消费者提供重试机制，这里由消费者做补偿重试
     *
     * @param orderFromVO 订单详情
     */
    Integer execCancelOperation(OrderForm orderFromVO);
}
