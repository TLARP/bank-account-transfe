package com.netease.kaola.generic.api.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 * 用户的总金额为扣减和未扣减总和
 */
@Data
public class AccountAmountRecords implements Serializable {
    private static final long serialVersionUID = -2286368382231381434L;

    //账户id
    private String accountId;

    //账户当前的未扣减余额
    private BigDecimal amount;

    //当前用户的扣减金额
    private BigDecimal deductionAmount;
}
