package kw.test;

import kw.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    @RequestMapping("/")
    public  String getStrings(){
        userService.save();
        return "oes";
    }
}
