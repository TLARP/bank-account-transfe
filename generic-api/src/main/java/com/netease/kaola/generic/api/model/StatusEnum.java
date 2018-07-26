package com.netease.kaola.generic.api.model;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public enum StatusEnum {
    TRY(0, "初始态"),
    TRY_SUCCCESS(1, "预确认状态"),
    CONFIRM(2, "执行状态"),
    SUCCESS(3, "成功状态"),
    CANCEL(4, "取消状态");

    private Integer status;

    private String desc;

    StatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
