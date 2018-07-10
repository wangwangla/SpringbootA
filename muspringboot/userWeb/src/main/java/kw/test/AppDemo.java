package kw.test;

import kw.test.domain.User;
import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.response.UserResponse;
import kw.test.service.UserService;
import kw.test.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * auther   kangwang
 */
@RestController
public class AppDemo {

    private UserService userService;

    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }
    @PostMapping("save")
    public  UserResponse userAdd(@RequestBody User user){
        System.out.print(user.getPassword()+"            "+user.getUsername());
        userService.save(user);
       /* return "保存成功！";*/
        UserResponse userResponse = new UserResponse();
        userResponse.setCode(UserMsg.USER_SAVE_SUCCESS.getCode());
        userResponse.setMsg(UserMsg.USER_SAVE_SUCCESS.getMsg());
        userResponse.setObject(user);
        return userResponse;
    }

    @PutMapping("delete/{id}")
    public  UserResponse deleteUser(@PathVariable("id") String id) throws UserException {
        User user = userService.findById(id);
        userService.deleteUser(id);
        UserResponse userResponse = new UserResponse();
        userResponse.setCode(UserMsg.USER_DELETE_SUCCESS.getCode());
        userResponse.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
        userResponse.setObject(user);
        return userResponse;
    }
    @PostMapping("edit")
    public  UserResponse deleteUser(@RequestBody User user) throws UserException {
        //将数据的封装放到service中还是在这里  以后的ID就从cookie取
        user = userService.findById(user.getId());
        if(user == null){
            throw new UserException(UserMsg.USER_NOT_FOUND.getMsg());
        }
        else {
            userService.update(user);
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setCode(UserMsg.USER_UPDATA_SUCCESS.getCode());
        userResponse.setMsg(UserMsg.USER_UPDATA_SUCCESS.getMsg());
        userResponse.setObject(user);
        return userResponse;
    }
    @GetMapping("findAll")
    public  UserResponse findAllUser() throws UserException {
        //将数据的封装放到service中还是在这里  以后的ID就从cookie取
        List<User> userList = userService.findAll();
        UserResponse userResponse = new UserResponse();
        userResponse.setCode(UserMsg.USER_FINDALL_SUCCESS.getCode());
        userResponse.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
        userResponse.setObjectList(userList);
        return userResponse;
    }
}
