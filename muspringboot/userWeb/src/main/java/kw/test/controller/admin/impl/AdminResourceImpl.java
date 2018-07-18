package kw.test.controller.admin.impl;

import kw.test.controller.admin.AdminResource;
import kw.test.dao.merchant.MerchantResponsitry;
import kw.test.domain.merchant.MerchantInfo;
import kw.test.msg.UserMsg;
import kw.test.request.AdminInfoRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.service.admin.AdminService;
import kw.test.service.admin.impl.AdminServiceImpl;
import kw.test.usercontant.UserDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * auther   kangwang
 * 2018/7/18
 */
@RestController
public class AdminResourceImpl implements AdminResource {

    @Autowired private MerchantResponsitry merchantResponsitry;

    @Override
    public ReturnValue activateMerchant(String id) {
        ReturnValue returnValue = new ReturnValue();
        MerchantInfo merchantInfo = merchantResponsitry.findById(id).get();
        merchantInfo.setStatus(UserDefault.MERCHANT_ACTIVE);
        merchantInfo = merchantResponsitry.save(merchantInfo);
        returnValue.setObject(merchantInfo);
        returnValue.setMsg(UserMsg.USER_ACTIVE_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue frostMerchant(String id) {
        ReturnValue returnValue = new ReturnValue();
        MerchantInfo merchantInfo = merchantResponsitry.findById(id).get();
        merchantInfo.setStatus(UserDefault.MERCHANT_ACK);
        merchantResponsitry.save(merchantInfo);
        returnValue.setMsg(UserMsg.USER_FROST_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnListValue findByActiveMerchant() {
        ReturnListValue returnListValue = new ReturnListValue();
        String status = UserDefault.MERCHANT_ACTIVE;
        List<MerchantInfo> merchantInfoList = merchantResponsitry.findMerchantInfoByStatus(status);
        returnListValue.setObject(merchantInfoList);
        returnListValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
        return returnListValue;
    }

    @Override
    public ReturnListValue findByForstMerchant() {
        ReturnListValue returnListValue = new ReturnListValue();
        String status = UserDefault.MERCHANT_ACK;
        List<MerchantInfo> merchantInfoList = merchantResponsitry.findMerchantInfoByStatus(status);
        returnListValue.setObject(merchantInfoList);
        returnListValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
        return returnListValue;
    }
}
