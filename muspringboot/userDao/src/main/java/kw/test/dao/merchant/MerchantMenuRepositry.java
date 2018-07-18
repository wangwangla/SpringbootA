package kw.test.dao.merchant;

import kw.test.domain.merchant.MerchantMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auther   kangwang
 * 2018/7/15
 */
@Repository
public interface MerchantMenuRepositry extends JpaRepository<MerchantMenu,String> {
}
