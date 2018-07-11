package kw.test.domain.merchant;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * auther   kangwang
 * 2018/7/11
 */

@Entity
@Table(name = "merchant_info")
public class MerchantInfo {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")/*这句是必须的，不写会有问题。*/
    private String id;

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    private String username;
    private String gender;
    private String address;
    private String image;
    private String registerNumber;
    private Date createTime;
    private Time closeTime;
    private Time openTime;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<MerchantCategory> categoryList;


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

    public MerchantInfo(String username, String gender, String address, String image, String registerNumber, Date createTime, Time closeTime, Time openTime) {

        this.username = username;
        this.gender = gender;
        this.address = address;
        this.image = image;
        this.registerNumber = registerNumber;
        this.createTime = createTime;
        this.closeTime = closeTime;
        this.openTime = openTime;
        categoryList = new ArrayList<>();
    }

    public MerchantInfo() {

        categoryList = new ArrayList<>();
    }
}
