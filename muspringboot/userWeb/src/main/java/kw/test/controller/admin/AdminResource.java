package kw.test.controller.admin;

import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * auther   kangwang
 * 2018/7/18
 */
@RequestMapping("admin")
public interface AdminResource {
    //激活
    @RequestMapping("activate")
    public ReturnValue activateMerchant(String id);
    //冻结
    @RequestMapping("frost")
    public ReturnValue frostMerchant(String id);
    //查看活动用户
    @RequestMapping("findactive")
    ReturnListValue findByActiveMerchant();
    //冻结用户
    @RequestMapping("findfrost")
    ReturnListValue findByForstMerchant();
}
