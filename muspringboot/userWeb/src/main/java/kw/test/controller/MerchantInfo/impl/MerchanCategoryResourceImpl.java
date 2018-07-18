package kw.test.controller.MerchantInfo.impl;

import kw.test.controller.MerchantInfo.MerchantCategoryResource;
import kw.test.request.MerchantCategoryRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.response.UserResponse;
import kw.test.service.merchantinfo.MerchantCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * auther   kangwang
 * 2018/7/14
 */
@RestController
public class MerchanCategoryResourceImpl implements MerchantCategoryResource {

    @Autowired private MerchantCategoryService merchantCategoryService;

    @Override
    public UserResponse saveMerchanCategory(@RequestBody MerchantCategoryRequest merchantCategoryRequest) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = merchantCategoryService.save(merchantCategoryRequest);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse deleteMerchanCategory(@PathVariable String id) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = merchantCategoryService.delete(id);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse updateMerchanCategory(@RequestBody MerchantCategoryRequest merchantInfoRequest) {
        UserResponse userResponse = new UserResponse();
        ReturnValue returnValue = merchantCategoryService.edit(merchantInfoRequest);
        userResponse.setObject(returnValue);
        return userResponse;
    }

    @Override
    public UserResponse findAll() {
        UserResponse userResponse = new UserResponse();
        ReturnListValue returnValue = merchantCategoryService.findAll();
        userResponse.setObject(returnValue);
        return userResponse;
    }
}
