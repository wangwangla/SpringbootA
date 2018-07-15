package kw.test.response.tools;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * auther   kangwang
 */
public class CookieUtils {
    //向
    public static void set(HttpServletResponse response, String token, String value, long age)
    {
        Cookie cookie = new Cookie(token,value);
        cookie.setPath("/");
        cookie.setMaxAge((int) age);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request, String name){
        Map<String,Cookie> map = readCookie(request);
        if(map.containsKey(name))//如果cookie中含有这个名字的token就将其封装并返回
        {
            return map.get(name);
        }
        else{
            return null;
        }
    }
    public static Map<String,Cookie> readCookie(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();
        //cookie获取到是一个数组
        Cookie[] cookies = request.getCookies();
        //数组不为空的时候，进行遍历循环
        if(cookies!=null)
        {
            //遍历cookie
            for(Cookie cookie : cookies)
            {
                System.out.print(cookie.getValue()+"-------------------------");
                /**
                 * 将变量的cookie放入一个map中，目的是为了是将查找方法
                 * 个人看法 将其存为map可以使用它的包含方法
                 */
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}