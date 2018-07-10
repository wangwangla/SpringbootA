package kw.test.service;

import kw.test.domain.User;
import kw.test.excepton.UserException;
import kw.test.request.UserRequest;
import kw.test.response.ReturnValue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * auther   kangwang
 */
@Service
public interface UserService {

    ReturnValue login(UserRequest userRequest);

    public void save(User user);

    User findById(String id);

    void deleteUser(String id) throws UserException;

    void update(User user);

    List<User> findAll();

    ReturnValue loginout();
}
