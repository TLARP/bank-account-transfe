package com.netease.kaola.compose;

import com.netease.haitao.common.response.Response;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public interface OrderComposeApi {

    /**
     * 获取一个订单号,用作幂等id
     */
    String getGorderId();
}
