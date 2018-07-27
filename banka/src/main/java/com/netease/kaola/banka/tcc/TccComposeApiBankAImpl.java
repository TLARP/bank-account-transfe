package com.netease.kaola.banka.tcc;

import com.netease.haitao.common.response.Response;
import com.netease.kaola.compose.TccComposeApi;
import com.netease.kaola.model.OrderFromVO;
import org.springframework.stereotype.Service;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("tccComposeApiBankAImpl")
public class TccComposeApiBankAImpl implements TccComposeApi {
    @Override
    public Response getTryMessage(OrderFromVO orderFromVO) {
        return null;
    }

    @Override
    public Response getConfirmMessage(OrderFromVO orderFromVO) {
        return null;
    }

    @Override
    public Response execCancelOperation(OrderFromVO orderFromVO) {
        return null;
    }
}
