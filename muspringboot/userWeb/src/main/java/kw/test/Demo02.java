package kw.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 */
@RestController
public class Demo02 {
    @RequestMapping("/")
    public String login(){
        return "login页面";
    }
    @RequestMapping("test")
    public String test(){
        return "test";
    }

}
