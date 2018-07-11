package kw.test.dao.merchant;

import kw.test.domain.merchant.MerchantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auther   kangwang
 */
@Repository
public interface MerchantResponsitry extends JpaRepository<MerchantInfo,String> {
}
