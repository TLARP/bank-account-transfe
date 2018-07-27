package com.netease.kaola.bankb.order;

import com.netease.kaola.bank.service.api.OrderComposeService4Bankb;
import com.netease.kaola.compose.OrderComposeApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("orderComposeApiImpl")
public class OrderComposeApiImpl implements OrderComposeApi {

    @Resource
    private OrderComposeService4Bankb orderComposeService;

    public String getGorderId() {
        return orderComposeService.getGorderId();
    }
}
