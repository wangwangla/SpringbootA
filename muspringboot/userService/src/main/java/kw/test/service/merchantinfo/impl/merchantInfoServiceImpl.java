package kw.test.service.merchantinfo.impl;

import kw.test.dao.merchant.MerchantResponsitry;
import kw.test.domain.merchant.MerchantInfo;
import kw.test.excepton.ArgumentNullExceptionHandler;
import kw.test.msg.UserMsg;
import kw.test.request.MerchantInfoRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.service.merchantinfo.MerchantInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * auther   kangwang
 */
@Service
public class merchantInfoServiceImpl implements MerchantInfoService {

    private MerchantResponsitry merchantResponsitry;

    @Autowired
    public void setMerchantResponsitry(MerchantResponsitry merchantResponsitry){
        this.merchantResponsitry=merchantResponsitry;
    }

    @Override
    public ReturnValue saveMerchantInfo(MerchantInfoRequest merchantInfoRequest) {
        ArgumentNullExceptionHandler.checkArgument(merchantInfoRequest);

        ReturnValue returnValue = new ReturnValue();
        MerchantInfo merchantInfo = new MerchantInfo();
        BeanUtils.copyProperties(merchantInfoRequest,merchantInfo);
        merchantResponsitry.save(merchantInfo);
        returnValue.setObject(merchantInfo);
        returnValue.setMsg(UserMsg.USER_SAVE_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue deleteMerchantInfo(String id) {
        ArgumentNullExceptionHandler.checkArgument(id);
        ReturnValue returnValue = new ReturnValue();
        try {
            Optional<MerchantInfo> optionalMerchantInfo = merchantResponsitry.findById(id);
            merchantResponsitry.deleteById(id);
            returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
            returnValue.setObject(optionalMerchantInfo.get());
            return returnValue;
        }catch(Exception e) {
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(id);
            return returnValue;
        }
    }

    @Override
    public ReturnValue updateMerchantInfo(MerchantInfoRequest merchantInfoRequest) {
        ArgumentNullExceptionHandler.checkArgument(merchantInfoRequest);
        MerchantInfo merchantInfo = null;
        ReturnValue returnValue = new ReturnValue();
        try {
            merchantInfo = merchantResponsitry.findById(merchantInfoRequest.getId()).get();
            merchantResponsitry.save(merchantInfo);
            returnValue.setMsg(UserMsg.USER_SAVE_SUCCESS.getMsg());
            returnValue.setObject(merchantInfo);
            return returnValue;
        }catch (Exception e){
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(merchantInfoRequest);
            return returnValue;
        }
    }

    @Override
    public ReturnListValue findAll() {
         List<MerchantInfo> merchantInfoList = merchantResponsitry.findAll();
        ReturnListValue returnValue = new ReturnListValue();
        if(merchantInfoList.size()>0){
            returnValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
            returnValue.setObject(merchantInfoList);
            return returnValue;
        }
        returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
        return returnValue;
    }

    /**
     * 通过名字查找
     */
    @Override
    public ReturnValue findByMerchantName(String merchantName) {
        ReturnValue returnValue = new ReturnValue();
        MerchantInfo merchantInfo = merchantResponsitry.findMerchantInfoByUsername(merchantName);
        if(merchantInfo == null) {
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            return returnValue;
        }
        returnValue.setObject(merchantInfo);
        returnValue.setMsg(UserMsg.USER_FINDALL_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue activateMerchant(String id) {
        return null;
    }

    @Override
    public ReturnValue frostMerchant(String id) {
        return null;
    }

    @Override
    public ReturnValue findByActiveMerchant() {
        return null;
    }

    @Override
    public ReturnValue findByForstMerchant() {
        return null;
    }


}
