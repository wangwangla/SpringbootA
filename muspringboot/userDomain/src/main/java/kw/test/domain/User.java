package kw.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * auther   kangwang
 * 2018/7/8
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private String id;
    private String username;
    private String password;


    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public User() {
    }
}
