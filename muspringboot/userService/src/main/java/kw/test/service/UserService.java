package kw.test.service;

import kw.test.domain.User;
import kw.test.excepton.UserException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * auther   kangwang
 */
@Service
public interface UserService {
    public void save(User user);

    User findById(String id);

    void deleteUser(String id) throws UserException;

    void update(User user);

    List<User> findAll();
}
