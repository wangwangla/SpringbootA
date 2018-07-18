package kw.test.service.admin.impl;

import kw.test.dao.admin.AdminInfoRepositry;
import kw.test.domain.admin.AdminInfo;
import kw.test.msg.UserMsg;
import kw.test.request.AdminInfoRequest;
import kw.test.response.ReturnValue;
import kw.test.response.tools.CookieUtils;
import kw.test.service.admin.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * auther   kangwang
 * 2018/7/17
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired private AdminInfoRepositry adminInfoRepositry;

    @Autowired private RedisTemplate<String,Object> redisTemplate;

    @Override
    public ReturnValue login(AdminInfoRequest adminInfoRequest) {
        ReturnValue returnValue = new ReturnValue();
        AdminInfo adminInfo = new AdminInfo();
        BeanUtils.copyProperties(adminInfoRequest,adminInfo);
        adminInfo = adminInfoRepositry.findAdminInfoByUsernameAndPassword(adminInfo.getUsername(),adminInfo.getPassword());
        if(adminInfo==null){
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(adminInfoRequest);
            return returnValue;
        }
        returnValue.setObject(adminInfo);
        returnValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue loginout() {
        ReturnValue returnValue = new ReturnValue();
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        Cookie cookie = CookieUtils.get(request, "token");
        if(cookie != null){

            //MerchantInfo merchantInfo = (MerchantInfo) redisTemplate.opsForValue().get(cookie.getValue());
            AdminInfo adminInfo = (AdminInfo) redisTemplate.opsForValue().get(cookie.getValue());
            returnValue.setObject(adminInfo.getUsername());
            redisTemplate.opsForValue().getOperations().delete(cookie.getValue());
            returnValue.setMsg(UserMsg.USER_LOGINOUT_SUCCESS.getMsg());
            CookieUtils.set(response, "token", null,0);
            return returnValue;
        }
        returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
        return returnValue;
    }
}
