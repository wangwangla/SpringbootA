package kw.test.msg;

import kw.test.excepton.ArgumentNullException;
import kw.test.excepton.UserException;

/**
 * auther   kangwang
 * 2018/7/9
 */
public enum  UserMsg {
    USER_DELETE_SUCCESS (1,"删除成功！"),
    USER_SAVE_SUCCESS (2,"保存成功！"),
    USER_NOT_FOUND(3,"未找到数据"),
    USER_UPDATA_SUCCESS (4,"用户更新成功！"),
    USER_FINDALL_SUCCESS (5,"查找成功！") ,
    USER_LOGIN_DEFAULT(6,"未登陆"),
    LOGIN_SUCCESS (7,"用户登录成功！") ,
    USER_EXITS_AREADY(8,"用户已经存在"),
    USER_LOGIN_SUCCESS (9,"用户登录成功！") ,
    USER_LOGINOUT_SUCCESS (10,"退出登录") ,
    USER_ACTIVE_SUCCESS(11,"激活成功"),
    USER_FROST_SUCCESS(12,"冻结成功.");
    private Integer code;
    private String msg;

    UserMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
