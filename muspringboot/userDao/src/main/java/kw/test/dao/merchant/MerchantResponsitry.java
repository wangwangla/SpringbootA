package kw.test.dao.merchant;

import kw.test.domain.merchant.MerchantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * auther   kangwang
 */
@Repository
public interface MerchantResponsitry extends JpaRepository<MerchantInfo,String> {
    //使用用户名和密码
    public MerchantInfo findMerchantInfoByUsername(String merchantName);
    //按照状态查找数据
    public List<MerchantInfo> findMerchantInfoByStatus(String status);
};
