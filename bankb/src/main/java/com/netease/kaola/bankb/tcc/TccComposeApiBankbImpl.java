package com.netease.kaola.bankb.tcc;

import com.netease.haitao.common.response.Response;
import com.netease.kaola.compose.TccComposeApi;
import com.netease.kaola.model.OrderFromVO;
import org.springframework.stereotype.Service;

/**
 * Created by hzwangqiqing
 * on 2018/7/27.
 */
@Service("tccComposeApiBankbImpl")
public class TccComposeApiBankbImpl implements TccComposeApi{
    public Response getTryMessage(OrderFromVO orderFromVO) {
        return Response.wrapError("system is not parepre!");
    }

    public Response getConfirmMessage(OrderFromVO orderFromVO) {
        return Response.wrapError("system is not parepre!");
    }

    public Response execCancelOperation(OrderFromVO orderFromVO) {
        return Response.wrapError("system is not parepre!");
    }
}
