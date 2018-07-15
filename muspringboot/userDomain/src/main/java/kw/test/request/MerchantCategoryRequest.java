package kw.test.request;

/**
 * auther   kangwang
 */
public class MerchantCategoryRequest {
    private String id;
    private String category;
    private String description;

    public MerchantCategoryRequest() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MerchantCategoryRequest(String id, String category, String description) {

        this.id = id;
        this.category = category;
        this.description = description;
    }
}
