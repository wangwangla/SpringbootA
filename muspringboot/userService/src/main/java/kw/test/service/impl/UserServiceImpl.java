package kw.test.service.impl;

import kw.test.dao.UserRepository;
import kw.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

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
    public void save() {
        userRepository.findAll();
    }
}
