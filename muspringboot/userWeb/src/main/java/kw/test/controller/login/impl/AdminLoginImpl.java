package kw.test.controller.login.impl;

import kw.test.controller.login.AdminLogin;
import kw.test.controller.login.UserLogin;
import kw.test.request.AdminInfoRequest;
import kw.test.response.ReturnValue;
import kw.test.response.UserResponse;
import kw.test.service.admin.AdminService;
import kw.test.service.admin.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 * 2018/7/18
 */
@RestController
public class AdminLoginImpl implements AdminLogin {

    @Autowired private AdminServiceImpl adminService;

    @Override
    public UserResponse AdminLogin(@RequestBody AdminInfoRequest adminInfoRequest) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = adminService.login(adminInfoRequest);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse AdminLoginOut() {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = adminService.loginout();
        userResponse.setObject(returnValue);
        return userResponse;
    }
}
