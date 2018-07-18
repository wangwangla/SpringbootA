package kw.test.controller.MerchantInfo.impl;

import kw.test.controller.MerchantInfo.MerchantInfoResource;
import kw.test.request.MerchantInfoRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.response.UserResponse;
import kw.test.service.merchantinfo.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 * 2018/7/11
 */
@RestController
public class  MerchantInfoResourceImpl implements MerchantInfoResource {

    @Autowired private MerchantInfoService merchantInfoService;

    @Override
    public UserResponse saveMerchantInfo(@RequestBody MerchantInfoRequest merchantInfoRequest) {
        ReturnValue returnValue = merchantInfoService.saveMerchantInfo(merchantInfoRequest);
        System.out.print(merchantInfoRequest.toString());
        UserResponse userResponse = new UserResponse();
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse deleteMerchantInfo(@PathVariable("id") String id) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = merchantInfoService.deleteMerchantInfo(id);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse updateMerchantInfo(@RequestBody MerchantInfoRequest merchantInfoRequest) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = merchantInfoService.updateMerchantInfo(merchantInfoRequest);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse findAll() {
        UserResponse userResponse = new UserResponse();
        ReturnListValue returnListValue = merchantInfoService.findAll();
        userResponse.setObject(returnListValue);
        return userResponse;
    }

    @Override
    public UserResponse findByName(String username) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = merchantInfoService.findByMerchantName(username);
        userResponse.setObject(returnValue);
        return userResponse;
    }
}
