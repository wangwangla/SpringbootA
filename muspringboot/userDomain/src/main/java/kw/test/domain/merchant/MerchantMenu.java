
package kw.test.domain.merchant;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * auther   kangwang
 * 2018/7/11
 */
@Entity
public class MerchantMenu {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    private String category;
    private String menuName;
    private Date createTime;
    private String mercateCategory_id;

    public MerchantMenu() {
    }

    public MerchantMenu(String id, String category, String menuName, Date createTime, String mercateCategory_id) {

        this.id = id;
        this.category = category;
        this.menuName = menuName;
        this.createTime = createTime;
        this.mercateCategory_id = mercateCategory_id;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMercateCategory_id() {
        return mercateCategory_id;
    }

    public void setMercateCategory_id(String mercateCategory_id) {
        this.mercateCategory_id = mercateCategory_id;
    }

    @Override
    public String toString() {
        return "MerchantMenu{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", menuName='" + menuName + '\'' +
                ", createTime=" + createTime +
                ", mercateCategory_id='" + mercateCategory_id + '\'' +
                '}';
    }
}