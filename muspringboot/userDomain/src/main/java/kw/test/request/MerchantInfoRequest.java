package kw.test.request;

import java.sql.Time;
import java.util.Date;

/**
 * auther   kangwang
 */
public class MerchantInfoRequest {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public MerchantInfoRequest() {

    }

    public MerchantInfoRequest(String id, String username, String gender, String address, String image, String registerNumber, Date createTime, Time closeTime, Time openTime) {

        this.id = id;
        this.username = username;
        this.gender = gender;
        this.address = address;
        this.image = image;
        this.registerNumber = registerNumber;
        this.createTime = createTime;
        this.closeTime = closeTime;
        this.openTime = openTime;
    }

    private String username;
    private String gender;
    private String address;
    private String image;
    private String registerNumber;
    private Date createTime;
    private Time closeTime;
    private Time openTime;
}
