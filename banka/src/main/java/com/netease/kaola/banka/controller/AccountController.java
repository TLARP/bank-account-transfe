package com.netease.kaola.banka.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by hzwangqiqing
 * on 2018/7/26.
 * http://localhost:8085/Unnamed_bank-account-transfe/transfer/getCurrentLoginAccount
 */
@RequestMapping("/transfer")
@Controller
public class AccountController {

    @RequestMapping("/getCurrentLoginAccount")
    @ResponseBody
    public Map<String, Object> getCurrentLoginAccount() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("accountId", "q_test1@163.com");
        return map;
    }
}
