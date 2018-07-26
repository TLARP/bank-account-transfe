package com.netease.kaola.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
public class MapUtils {
    /**
     * 返回失败,状态码待定
     */
    public static Map<String, Object> mapWithError(String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("retCode", 400);
        map.put("retDesc", message);
        return map;
    }

    /**
     *
     */
    public static Map<String, Object> mapWithSuccess(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("retCode", 200);
        map.put("data", data);
        return map;
    }
}
