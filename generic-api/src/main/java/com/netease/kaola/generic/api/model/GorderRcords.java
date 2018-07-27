package com.netease.kaola.generic.api.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Data
public class GorderRcords implements Serializable {
    private static final long serialVersionUID = -2286368382231381434L;

    private Long id;

    private String userName;
}
