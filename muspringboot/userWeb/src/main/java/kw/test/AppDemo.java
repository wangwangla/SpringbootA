package kw.test;

import kw.test.domain.User;
import kw.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 */
@RestController
public class AppDemo {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }
    @PostMapping("/save")
    public  String getStrings(@RequestBody User user){
        System.out.print(user.getPassword()+"            "+user.getUsername());
        userService.save(user);
        return "保存成功！";
    }
}
