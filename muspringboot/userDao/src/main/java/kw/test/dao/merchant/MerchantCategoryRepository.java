package kw.test.dao.merchant;

import kw.test.domain.merchant.MerchantCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auther   kangwang
 * 2018/7/11
 */
@Repository
public interface MerchantCategoryRepository extends JpaRepository<MerchantCategory,String> {
}
