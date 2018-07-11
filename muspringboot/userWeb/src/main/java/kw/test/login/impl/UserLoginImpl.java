package kw.test.login.impl;

import kw.test.domain.User;
import kw.test.login.UserLogin;
import kw.test.request.UserRequest;
import kw.test.response.ReturnValue;
import kw.test.response.UserResponse;
import kw.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 */
@RestController
public class UserLoginImpl implements UserLogin {

    @Autowired private UserService userService;

    @Override
    public UserResponse login(@RequestBody UserRequest userRequest) {
        ReturnValue returnValue = userService.login(userRequest);
        UserResponse<User> userUserResponse = new UserResponse<>();
        userUserResponse.setObject(returnValue);
        return userUserResponse;
    }

    @Override
    public UserResponse loginout() {
        userService.loginout();
        UserResponse<User> userUserResponse = new UserResponse<>();
        /*userUserResponse.setObject(returnValue);*/
        return userUserResponse;
    }

    public UserResponse token(){
        UserResponse userResponse = new UserResponse();
        userResponse.setObject("wosssssssss");
        userResponse.setCode(1000);
        return userResponse;
    }

}
