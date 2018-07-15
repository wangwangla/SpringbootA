package kw.test.service.merchantinfo;

import kw.test.request.MerchantLoginRequest;
import kw.test.response.ReturnValue;

/**
 * auther   kangwang
 * 2018/7/13
 */
public interface MerchantLoginService {
    ReturnValue login(MerchantLoginRequest userInfoRequest);

    ReturnValue loginOut();
}
