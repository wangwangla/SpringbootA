package kw.test.service.merchantinfo.impl;

import kw.test.dao.merchant.MerchantLoginRepositry;
import kw.test.domain.merchant.MerchantInfo;
import kw.test.domain.user.UserInfo;
import kw.test.excepton.ArgumentNullExceptionHandler;
import kw.test.msg.UserMsg;
import kw.test.request.MerchantLoginRequest;
import kw.test.response.ReturnValue;
import kw.test.response.tools.CookieUtils;
import kw.test.service.merchantinfo.MerchantLoginService;
import kw.test.usercontant.UserDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * auther   kangwang
 * 2018/7/13
 */
@Service
public class MerchantLoginServiceImpl implements MerchantLoginService {

    @Autowired private MerchantLoginRepositry merchantLoginRepositry;

    @Autowired private RedisTemplate<String,Object> redisTemplate;

    @Override
    public ReturnValue login(MerchantLoginRequest userInfoRequest) {
        ArgumentNullExceptionHandler.checkArgument(userInfoRequest);
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        ReturnValue returnValue = new ReturnValue();
        MerchantInfo userInfo = merchantLoginRepositry.findMerchantInfoByUsernameAndPassword(userInfoRequest.getUsername(),userInfoRequest.getPassword());
        if(userInfo == null){
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(userInfoRequest);
            return returnValue;
        }

        returnValue.setObject(userInfo);
        //将cookie设置
        String token = UUID.randomUUID().toString();
        CookieUtils.set(response,"token",token,UserDefault.COOKIE_MAX_AGE);
        redisTemplate.opsForValue().set(token,userInfo,UserDefault.COOKIE_MAX_AGE,TimeUnit.MINUTES);
        returnValue.setMsg(UserMsg.USER_LOGIN_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue loginOut() {
        ReturnValue returnValue = new ReturnValue();
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        Cookie cookie = CookieUtils.get(request, "token");
        if(cookie != null){
            //删除redis
            MerchantInfo merchantInfo = (MerchantInfo) redisTemplate.opsForValue().get(cookie.getValue());
            returnValue.setObject(merchantInfo.getUsername());
            redisTemplate.opsForValue().getOperations().delete(cookie.getValue());
            //将cookie中删除
            returnValue.setMsg(UserMsg.USER_LOGINOUT_SUCCESS.getMsg());
            CookieUtils.set(response, "token", null,0);
            return returnValue;
        }

        returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
        return returnValue;
    }


}
