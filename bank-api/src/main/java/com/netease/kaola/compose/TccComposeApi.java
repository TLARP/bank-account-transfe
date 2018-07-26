package com.netease.kaola.compose;

import com.netease.kaola.model.OrderFromVO;
import com.netease.haitao.common.response.Response;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface TccComposeApi {

    /**
     * Response.error或者发生异常都认为是try-信息错误
     *
     * @param orderFromVO 订单详情
     */
    Response getTryMessage(OrderFromVO orderFromVO);


    /**
     * 获取账户扣减操作的执行状态
     *
     * @param orderFromVO 订单详情
     */
    Response getConfirmMessage(OrderFromVO orderFromVO);


    /**
     * 发生错误由消费者提供重试机制，这里由消费者做补偿重试
     *
     * @param orderFromVO 订单详情
     */
    Response execCancelOperation(OrderFromVO orderFromVO);
}
