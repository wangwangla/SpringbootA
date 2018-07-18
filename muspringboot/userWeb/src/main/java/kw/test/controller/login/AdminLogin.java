package kw.test.controller.login;

import kw.test.request.AdminInfoRequest;
import kw.test.response.UserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * auther   kangwang
 * 2018/7/18
 */
@RequestMapping("/admin")
public interface AdminLogin {
    @RequestMapping("/login")
    public UserResponse AdminLogin(@RequestBody AdminInfoRequest adminInfoRequest);

    @RequestMapping("/loginout")
    public UserResponse AdminLoginOut();
}
