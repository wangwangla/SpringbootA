package kw.test.controller.login.impl;

import kw.test.controller.login.UserLogin;
import kw.test.domain.user.UserInfo;
import kw.test.request.MerchantLoginRequest;
import kw.test.response.ReturnValue;
import kw.test.response.UserResponse;
import kw.test.service.merchantinfo.MerchantLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 * 2018/7/13
 */
@RestController
public class UserLoginImpl implements UserLogin {

    @Autowired private MerchantLoginService userInfoService;

    @Override
    public UserResponse<UserInfo> login(@RequestBody MerchantLoginRequest userInfoRequest) {
        ReturnValue returnValue = userInfoService.login(userInfoRequest);
        UserResponse<UserInfo> userInfoUserResponse = new UserResponse<UserInfo>();
        userInfoUserResponse.setObject(returnValue);
        return userInfoUserResponse;
    }

    @Override
    public UserResponse loginOut() {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = userInfoService.loginOut();
        userResponse.setObject(returnValue);
        return userResponse;
    }
}
