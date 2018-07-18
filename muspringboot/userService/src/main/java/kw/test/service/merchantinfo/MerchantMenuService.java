package kw.test.service.merchantinfo;

import kw.test.request.MerchantMenuRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;

/**
 * auther   kangwang
 */

public interface MerchantMenuService {
    ReturnValue saveMerchantMeun(MerchantMenuRequest merchantMenuRequest);

    ReturnValue deleteMerchantMeun(String id);

    ReturnValue editMerchantMeun(MerchantMenuRequest merchantMenuRequest);

    ReturnListValue findMerchantMeun();
}
