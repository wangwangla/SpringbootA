package kw.test.response;

/**
 * auther   kangwang
 */
public class ReturnValue<T> {
    private String msg;
    private T object;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public ReturnValue(String msg, T object) {

        this.msg = msg;
        this.object = object;
    }

    public ReturnValue() {

    }
}
