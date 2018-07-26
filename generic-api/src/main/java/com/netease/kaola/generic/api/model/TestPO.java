package com.netease.kaola.generic.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hzwangqiqing
 * on 2018/7/26.
 */
@Data
public class TestPO implements Serializable {
    private static final long serialVersionUID = -2286368382231381434L;

    private Long id;

    private String name;
}
