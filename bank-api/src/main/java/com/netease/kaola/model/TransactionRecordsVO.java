package com.netease.kaola.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Data
public class TransactionRecordsVO implements Serializable {
    private static final long serialVersionUID = -4009928345190261751L;

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
     * @link com.netease.kaola.generic.api.model.StatusEnum}
     */
    private Integer statas;

    //执行的是递增还是扣减操作-0-扣减 1-递增
    private Integer deductionOrIncrease;
}
