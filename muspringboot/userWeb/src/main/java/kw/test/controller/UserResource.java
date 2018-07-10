package kw.test.controller;

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
public interface UserResource {

    public  UserResponse userAdd(@RequestBody User user);

    @PutMapping("delete/{id}")
    public  UserResponse deleteUser(@PathVariable("id") String id) throws UserException;

    @PostMapping("edit")
    public  UserResponse deleteUser(@RequestBody User user) throws UserException;

    @GetMapping("findAll")
    public  UserResponse findAllUser() throws UserException;
}
