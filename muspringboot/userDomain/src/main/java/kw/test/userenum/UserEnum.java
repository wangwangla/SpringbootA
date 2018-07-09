package kw.test.userenum;

/**
 * auther   kangwang
 */
public enum  UserEnum {
    USER_SAVE_SUCCESS(1,"保存成功！"),
    USER_DELETE_SUCCESS(2,"删除成功！"),
    USER_NOT_FOUND(3,"查找失败！"),
    USER_UPDATA_SUCCESS(4,"更新成功");
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

    UserEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private Integer code;
    private String msg;
}
