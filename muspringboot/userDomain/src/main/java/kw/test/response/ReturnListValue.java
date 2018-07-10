package kw.test.response;

import java.util.List;

/**
 * auther   kangwang
 */
public class ReturnListValue<T> {
    private String msg;
    private List<T> object;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getObject() {
        return object;
    }

    public void setObject(List<T> object) {
        this.object = object;
    }

    public ReturnListValue(String msg, List<T> object) {

        this.msg = msg;
        this.object = object;
    }

    public ReturnListValue() {

    }
}
