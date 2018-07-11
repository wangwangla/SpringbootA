package kw.test.service;

import kw.test.domain.User;
import kw.test.excepton.UserException;
import kw.test.request.UserRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * auther   kangwang
 */
@Service
public interface UserService {

    ReturnValue login(UserRequest userRequest);

    ReturnValue save(User user);

    User findById(String id);

    ReturnValue deleteUser(String id) throws UserException;

    ReturnValue update(User user);

    ReturnListValue<User> findAll();

    ReturnValue loginout();

    ReturnValue findUserById(String id);
}
