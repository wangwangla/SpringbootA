package kw.test.dao.admin;

import kw.test.domain.admin.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auther   kangwang
 * 2018/7/17
 */
@Repository
public interface AdminInfoRepositry extends JpaRepository<AdminInfo,String> {
    //使用用户名和密码查找
    public AdminInfo findAdminInfoByUsernameAndPassword(String username,String password);
}
