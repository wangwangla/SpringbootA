package kw.test.service.merchantinfo;

import kw.test.request.MerchantInfoRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;

/**
 * auther   kangwang
 */

public interface MerchantInfoService {

    ReturnValue saveMerchantInfo(MerchantInfoRequest merchantInfoRequest);

    ReturnValue deleteMerchantInfo(String id);

    ReturnValue updateMerchantInfo(MerchantInfoRequest merchantInfoRequest);

    ReturnListValue findAll();
}
