package kw.test.dao.merchant;

import kw.test.domain.merchant.MerchantMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * auther   kangwang
 * 2018/7/15
 */
public interface MerchantMenuRepositry extends JpaRepository<MerchantMenu,String> {
}
