package kw.test.service.merchantinfo.impl;

import kw.test.dao.merchant.MerchantMenuRepositry;
import kw.test.domain.merchant.MerchantMenu;
import kw.test.excepton.ArgumentNullExceptionHandler;
import kw.test.msg.UserMsg;
import kw.test.request.MerchantMenuRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.service.merchantinfo.MerchantMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * auther   kangwang
 * 2018/7/15
 */
@Service
public class MerchantMenuServiceImpl implements MerchantMenuService {

    @Autowired private MerchantMenuRepositry merchantMenuRepositry;

    @Override
    public ReturnValue saveMerchantMeun(MerchantMenuRequest merchantMenuRequest) {
        ArgumentNullExceptionHandler.checkArgument(merchantMenuRequest);

        ReturnValue returnValue = new ReturnValue();
        MerchantMenu merchantMenu = new MerchantMenu();
        BeanUtils.copyProperties(merchantMenuRequest,merchantMenu);
        merchantMenu.setCreateTime(new Date());
        merchantMenu = merchantMenuRepositry.save(merchantMenu);
        returnValue.setObject(merchantMenu);
        returnValue.setMsg(UserMsg.USER_SAVE_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue deleteMerchantMeun(String id) {
        ReturnValue returnValue = new ReturnValue();
        MerchantMenu merchantMenu = merchantMenuRepositry.findById(id).get();
        if(merchantMenu == null)
        {
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            return returnValue;
        }
        merchantMenuRepositry.delete(merchantMenu);
        returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
        returnValue.setObject(merchantMenu);
        return returnValue;
    }

    @Override
    public ReturnValue editMerchantMeun(MerchantMenuRequest merchantMenuRequest) {
        ArgumentNullExceptionHandler.checkArgument(merchantMenuRequest);

        ReturnValue returnValue = new ReturnValue();
        MerchantMenu merchantMenu = new MerchantMenu();
        BeanUtils.copyProperties(merchantMenuRequest,merchantMenu);
        merchantMenu.setCreateTime(new Date());
        merchantMenuRepositry.save(merchantMenu);
        returnValue.setObject(merchantMenu);
        returnValue.setMsg(UserMsg.USER_UPDATA_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnListValue findMerchantMeun() {
        ReturnListValue returnValue = new ReturnListValue();
        List<MerchantMenu> merchantMenuList = merchantMenuRepositry.findAll();
        if(merchantMenuList.size()>0)
        {
            returnValue.setObject(merchantMenuList);
            returnValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
            return returnValue;
        }
        returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
        return returnValue;
    }
}
