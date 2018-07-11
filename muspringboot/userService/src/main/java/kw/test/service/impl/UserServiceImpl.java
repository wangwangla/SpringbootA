package kw.test.service.impl;

import kw.test.dao.UserRepository;
import kw.test.domain.User;
import kw.test.excepton.ArgumentNullExceptionHandler;
import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.request.UserRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.response.tools.CookieUtils;
import kw.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * auther   kangwang
 * 2018/7/8
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setUserRepository(UserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public ReturnValue login(UserRequest userRequest) {
        ArgumentNullExceptionHandler.checkArgument(userRequest);

        ReturnValue returnValue = new ReturnValue();
        User user = userRepository.findUserByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword());
        if(user == null){
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(userRequest);
            return returnValue;
        }
        returnValue.setObject(user);
        returnValue.setMsg(UserMsg.LOGIN_SUCCESS.getMsg());
        /*设置token*/
        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(token,user.getUsername());
        return returnValue;
    }

    @Override
    public ReturnValue save(User user) {
        ArgumentNullExceptionHandler.checkArgument(user);
        ReturnValue returnValue = new ReturnValue();
        user = userRepository.save(user);
        returnValue.setMsg(UserMsg.USER_SAVE_SUCCESS.getMsg());
        returnValue.setObject(user);
        return returnValue;
    }

    @Override
    public User findById(String id) {
        ArgumentNullExceptionHandler.checkArgument(id);
        return userRepository.findById(id).get();
    }

    @Override
    public ReturnValue deleteUser(String id) throws UserException {
        ArgumentNullExceptionHandler.checkArgument(id);

        ReturnValue returnValue = new ReturnValue();
        User user = findById(id);
        if(user == null) {
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            return returnValue;
        }
        returnValue.setObject(user);
        returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
        userRepository.deleteById(id);
        return returnValue;
    }

    @Override
    public ReturnValue update(User user) {
        ArgumentNullExceptionHandler.checkArgument(user);
        ReturnValue returnValue = new ReturnValue();
        if(findById(user.getId())==null){
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(user);
            return returnValue;
        }
        userRepository.save(user);
        returnValue.setObject(user);
        returnValue.setMsg(UserMsg.USER_UPDATA_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnListValue<User> findAll() {
        List<User> userList = userRepository.findAll();
        ReturnListValue<User> returnListValue = new ReturnListValue<>();
        if(userList.size()>0) {
            returnListValue.setObject(userList);
            returnListValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
            return returnListValue;
        }
        returnListValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
        return returnListValue;
    }

    @Override
    public ReturnValue loginout() {
        /*步骤：
        * 先得到cookie
        * 在从cookie中获取的token的key
        * 将cookie删除
        * 将Redis中数据删除
        * */
        ReturnValue returnValue = new ReturnValue();
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        Cookie cookie = CookieUtils.get(request, "token");
        /*有疑问！！！！！！！！！！！！！！！！！！！！！！！！！！！*/
        returnValue.setObject(cookie.getName());
        if(cookie != null){
            //删除redis
            stringRedisTemplate.opsForValue().getOperations().delete(cookie.getValue());
           //将cookie中删除
            CookieUtils.set(response, "token", null,0);
        }
        returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());

        return returnValue;
    }

    @Override
    public ReturnValue findUserById(String id) {
        ReturnValue returnValue = new ReturnValue();
        returnValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
        returnValue.setObject(findById(id));
         return returnValue;
    }
}
