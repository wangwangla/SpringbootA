package kw.test.aop;

import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.response.tools.CookieUtils;
import kw.test.usercontant.UserDefault;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * auther   kangwang
 * 2018/7/10
 */
@Component
@Aspect
public class UserAuth {
    @Pointcut("execution(public * kw.test.controller.*.*(..))")
    public void role(){

    }

    @Before(value = "role()")
    public void beforeAuth() throws UserException {
        //获取到request
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //将request中获取token
        Cookie cookie = CookieUtils.get(request, "token");
        //判断cookie中是否有值，如果没有值就抛出异常
        if(cookie==null){
            throw new UserException(UserMsg.USER_LOGIN_DEFAULT.getMsg());
        }else {
            cookie.setMaxAge(UserDefault.TOKEN_MAX_AGE);

        }
    }
    @After("role()")
    public void afterAuth() throws UserException {
        //获取到request
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //将request中获取token
        Cookie cookie = CookieUtils.get(request, "token");
        //判断cookie中是否有值，如果没有值就抛出异常
        if(cookie==null){
            throw new UserException(UserMsg.USER_LOGIN_DEFAULT.getMsg());
        }else {
            cookie.setMaxAge(UserDefault.TOKEN_MAX_AGE);
        }
    }
}
