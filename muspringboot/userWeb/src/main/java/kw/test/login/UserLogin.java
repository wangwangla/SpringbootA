package kw.test.login;

import kw.test.request.UserRequest;
import kw.test.response.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 */

public interface UserLogin {
    @PostMapping ("login")
    public UserResponse login(@RequestBody UserRequest userRequest) ;
    @RequestMapping("loginout")
    public UserResponse loginout();
    @RequestMapping("/")
    public UserResponse token();
}
