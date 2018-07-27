package com.netease.kaola.bank.service.impl;

import com.netease.kaola.bank.service.api.OrderComposeService4Bankb;
import com.netease.kaola.generic.api.bankb.mapper.GorderGetMapper;
import com.netease.kaola.generic.api.model.GorderRcords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("orderComposeService4BankbImpl")
public class OrderComposeService4BankbImpl implements OrderComposeService4Bankb {
    @Resource
    private GorderGetMapper gorderGetMapper;

    @Override
    public String getGorderId() {
        GorderRcords gorderRcords = new GorderRcords();
        gorderRcords.setUserName("默认附加字段没啥用");
        gorderGetMapper.insertGorderRcords(gorderRcords);
        return String.valueOf(gorderRcords.getId());
    }
}
