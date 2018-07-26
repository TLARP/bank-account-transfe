package com.netease.kaola.generic.api.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Data
public class OrderForm implements Serializable {

    private static final long serialVersionUID = -4009928345190261751L;

    //订单号
    private String orderId;

    //转账金额
    private BigDecimal transferAmount;

    //接受者账户
    private String acceptAccount;
}
