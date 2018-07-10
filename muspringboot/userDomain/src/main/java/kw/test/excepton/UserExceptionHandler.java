package kw.test.excepton;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * auther   kangwang
 */
@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value=UserException.class)
    public String  handlerRoleException(){
        System.out.print("我是啦啦啦！");
        return "redirect:test";
    }
}
