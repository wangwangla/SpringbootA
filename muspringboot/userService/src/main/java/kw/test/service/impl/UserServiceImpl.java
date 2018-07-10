package kw.test.service.impl;

import kw.test.dao.UserRepository;
import kw.test.domain.User;
import kw.test.excepton.ArgumentNullExceptionHandler;
import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.request.UserRequest;
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
        stringRedisTemplate.opsForValue().set(token,user.getUsername(),30,TimeUnit.MINUTES);
        return returnValue;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(String id) throws UserException {
        if(findById(id)==null){
            throw new UserException(UserMsg.USER_NOT_FOUND.getMsg());
        }
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
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
}
