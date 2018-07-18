package kw.test.dao.merchant;

import kw.test.domain.merchant.MerchantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auther   kangwang
 * 2018/7/13
 */
@Repository
public interface MerchantLoginRepositry extends JpaRepository<MerchantInfo,String> {
    MerchantInfo findMerchantInfoByUsernameAndPassword(String username,String password);
}
