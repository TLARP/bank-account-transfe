package com.netease.kaola.generic.api.mapper;

import com.netease.kaola.generic.api.model.TestPO;

/**
 * Created by hzwangqiqing
 * on 2018/7/26.
 */
public interface TestMapper {
    /**
     * 插入测试记录
     */
    Integer insertTest(TestPO testPO);
}
