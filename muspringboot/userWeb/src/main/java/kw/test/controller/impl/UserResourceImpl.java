package kw.test.controller.impl;

import kw.test.controller.UserResource;
import kw.test.domain.User;
import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.response.UserResponse;
import kw.test.service.UserService;
import kw.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * auther   kangwang
 */
@RestController
public class UserResourceImpl implements UserResource {

    private UserService userService;

    @Autowired
    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }

    public UserResponse userAdd(@RequestBody User user){
        ReturnValue returnValue =userService.save(user);
        /* return "保存成功！";*/
        UserResponse userResponse = new UserResponse();
        userResponse.setObject(returnValue);
        return userResponse;
    }

    public  UserResponse deleteUser(@PathVariable("id") String id) throws UserException {
        ReturnValue returnValue = userService.deleteUser(id);
        UserResponse userResponse = new UserResponse();
        userResponse.setObject(returnValue);
        return userResponse;
    }


    public  UserResponse edit(@RequestBody User updataUser) throws UserException {
        //将数据的封装放到service中还是在这里  以后的ID就从cookie取
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = userService.update(updataUser);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    public  UserResponse findAllUser() throws UserException {
        //将数据的封装放到service中还是在这里  以后的ID就从cookie取
        ReturnListValue<User> returnListValue = userService.findAll();
        UserResponse userResponse = new UserResponse();
        userResponse.setObject(returnListValue);
        return userResponse;
    }
}