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
    private String id;
    private String category;
    private Date createTime;
    private String description;
    private String merchant_id;

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

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public MerchantCategory(String id, String category, Date createTime, String description, String merchant_id) {

        this.id = id;
        this.category = category;
        this.createTime = createTime;
        this.description = description;
        this.merchant_id = merchant_id;
    }
}
