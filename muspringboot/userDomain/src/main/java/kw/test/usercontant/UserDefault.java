package kw.test.usercontant;

import kw.test.excepton.ArgumentNullException;

/**
 * auther   kangwang
 */
public interface UserDefault {
    Integer COOKIE_MAX_AGE=30;
    Integer TOKEN_MAX_AGE=30;
    String  MERCHANT_ACK = "fallow";//默认是不活跃
    String  MERCHANT_ACTIVE = "active";//活跃
}
