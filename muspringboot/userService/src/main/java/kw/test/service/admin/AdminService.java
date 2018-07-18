package kw.test.service.admin;

import kw.test.request.AdminInfoRequest;
import kw.test.response.ReturnValue;
import org.springframework.stereotype.Service;

/**
 * auther   kangwang
 */

public interface AdminService {
    //登录
    public ReturnValue login(AdminInfoRequest adminInfoRequest);
    //登出
    public ReturnValue loginout();
    //激活
    public ReturnValue activateMerchant(String id);
    //冻结
    public ReturnValue frostMerchant(String id);
    //查看活动用户
    ReturnValue findByActiveMerchant();
    //冻结用户
    ReturnValue findByForstMerchant();

}
