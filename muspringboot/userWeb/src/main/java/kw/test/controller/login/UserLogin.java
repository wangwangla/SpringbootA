package kw.test.controller.login;

import kw.test.request.MerchantLoginRequest;
import kw.test.response.UserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * auther   kangwang
 */
public interface UserLogin {

    @RequestMapping("/login")
    UserResponse login(@RequestBody MerchantLoginRequest userInfoRequest);

    @RequestMapping("/loginout")
    UserResponse loginOut();
}
