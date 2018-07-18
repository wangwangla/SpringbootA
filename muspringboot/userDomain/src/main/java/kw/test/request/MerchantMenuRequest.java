package kw.test.request;

import java.util.Date;

/**
 * auther   kangwang
 * 2018/7/15
 */
public class MerchantMenuRequest {
    private String id;
    private String category;
    private String mercateCategory_id;

    public MerchantMenuRequest() {
    }

    @Override
    public String toString() {
        return "MerchantMenuRequest{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", mercateCategory_id='" + mercateCategory_id + '\'' +
                '}';
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

    public String getMercateCategory_id() {
        return mercateCategory_id;
    }

    public void setMercateCategory_id(String mercateCategory_id) {
        this.mercateCategory_id = mercateCategory_id;
    }

    public MerchantMenuRequest(String id, String category, String mercateCategory_id) {

        this.id = id;
        this.category = category;
        this.mercateCategory_id = mercateCategory_id;
    }
}
