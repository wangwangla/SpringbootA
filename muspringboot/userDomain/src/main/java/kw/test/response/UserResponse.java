package kw.test.response;

import java.util.List;

/**
 * auther   kangwang
 */
public class UserResponse<T> {
    private Integer code;
    private String msg;
    private Object object;

    public UserResponse(Integer code, String msg, Object object, List<T> objectList) {
        this.code = code;
        this.msg = msg;
        this.object = object;
        this.objectList = objectList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }

    public UserResponse() {

    }

    private List<T> objectList;
}
