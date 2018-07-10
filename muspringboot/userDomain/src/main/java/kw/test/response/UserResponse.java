package kw.test.response;

import java.util.List;

/**
 * auther   kangwang
 */
public class UserResponse<T> {
    private Integer code;

    private Object object;

    public UserResponse() {
    }

    public UserResponse(Integer code, Object object) {
        this.code = code;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
