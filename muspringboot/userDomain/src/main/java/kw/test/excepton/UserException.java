package kw.test.excepton;

/**
 * auther   kangwang
 */
public class UserException extends Exception{
   private String msg;
    public UserException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
