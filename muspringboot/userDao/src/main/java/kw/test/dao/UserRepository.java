package kw.test.dao;

import kw.test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auther   kangwang
 * 2018/7/8
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
