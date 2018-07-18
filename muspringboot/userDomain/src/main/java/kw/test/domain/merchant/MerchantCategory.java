package kw.test.domain.merchant;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * auther   kangwang
 * 2018/7/11
 */

@Entity
@Table(name = "merchant_category")
public class MerchantCategory {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    private String category;
    private Date createTime;
    private String description;
    private String merchantId;//标识一个商户

    public MerchantCategory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public MerchantCategory(String category, Date createTime, String description, String merchantId) {

        this.category = category;
        this.createTime = createTime;
        this.description = description;
        this.merchantId = merchantId;
    }
}
