package kw.test.service.impl;

import kw.test.dao.UserRepository;
import kw.test.domain.User;
import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;import java.util.List;

/**
 * auther   kangwang
 * 2018/7/8
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository repository){
        this.userRepository = repository;
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
}
