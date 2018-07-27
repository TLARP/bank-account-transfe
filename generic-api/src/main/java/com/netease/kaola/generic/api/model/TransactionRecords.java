package com.netease.kaola.generic.api.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Data
public class TransactionRecords implements Serializable {
    private static final long serialVersionUID = -2286368382231381434L;
    //订单号
    private Long id;

    //转出账户
    private String accountIdOut;

    //转入账户
    private String accountIdIn;

    //扣减金额
    private BigDecimal deductionAmount;

    //交易时间
    private Timestamp timestamp;

    /**
     *  @link com.netease.kaola.generic.api.model.StatusEnum}
     */
    private Integer statas;

    //执行递增还是扣减 0-扣减 1-递增
    private Integer deductionOrIncrease;
}
