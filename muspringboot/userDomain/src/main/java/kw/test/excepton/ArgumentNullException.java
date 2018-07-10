package kw.test.excepton;

/**
 * auther   kangwang
 * 2018/7/10
 */
public class ArgumentNullException extends Throwable {
    private String msg;

    public ArgumentNullException() {
    }

    public ArgumentNullException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
