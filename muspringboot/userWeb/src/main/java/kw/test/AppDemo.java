package kw.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 */
@RestController
public class AppDemo {
    @RequestMapping("/")
    public  String getStrings(){
        return "oes";
    }
}
