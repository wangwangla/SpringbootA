package kw.test.service;

import kw.test.domain.User;
import org.springframework.stereotype.Service;

/**
 * auther   kangwang
 */
@Service
public interface UserService {
    public void save(User user);
}
