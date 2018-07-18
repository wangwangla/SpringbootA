package kw.test.service.merchantinfo;

import kw.test.request.MerchantInfoRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;

/**
 * auther   kangwang
 */

public interface MerchantInfoService {
    //增加
    ReturnValue saveMerchantInfo(MerchantInfoRequest merchantInfoRequest);
    //删除
    ReturnValue deleteMerchantInfo(String id);
    //更新
    ReturnValue updateMerchantInfo(MerchantInfoRequest merchantInfoRequest);
    //查找全部
    ReturnListValue findAll();
    //按照名字查
    ReturnValue findByMerchantName(String merchantName);
    //激活
    public ReturnValue activateMerchant(String id);
    //冻结
    public ReturnValue frostMerchant(String id);
    //查看活动用户
    ReturnValue findByActiveMerchant();
    //冻结用户
    ReturnValue findByForstMerchant();
}
