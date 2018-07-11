package kw.test.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * auther   kangwang
 */
public class UserInfo {
    private String id;
    private String userName;
    private String passWord;
    private String gender;
    private Integer age;
    private String tel;
    private String address;
    private Date registerTime;

    public List<UserOrder> getUserOrderList() {
        return userOrderList;
    }

    public void setUserOrderList(List<UserOrder> userOrderList) {
        this.userOrderList = userOrderList;
    }

    public UserInfo(String id, String userName, String passWord, String gender, Integer age, String tel, String address, Date registerTime, List<UserOrder> userOrderList) {

        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.registerTime = registerTime;
        this.userOrderList = userOrderList;
    }

    private List<UserOrder> userOrderList = new ArrayList<UserOrder>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public UserInfo() {

    }

    public UserInfo(String id, String userName, String passWord, String gender, Integer age, String tel, String address, Date registerTime) {

        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.registerTime = registerTime;
    }
}
