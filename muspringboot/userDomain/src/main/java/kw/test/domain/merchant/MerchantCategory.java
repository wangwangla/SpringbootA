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
    @ManyToOne(fetch = FetchType.EAGER)
    private MerchantInfo merchantInfo;

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public MerchantCategory(String category, Date createTime, String description, MerchantInfo merchantInfo) {

        this.category = category;
        this.createTime = createTime;
        this.description = description;
        this.merchantInfo = merchantInfo;
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

    public MerchantCategory(String id, String category, Date createTime, String description) {

        this.id = id;
        this.category = category;
        this.createTime = createTime;
        this.description = description;
    }

    public MerchantCategory() {

    }
}
