package kw.test.service.merchantinfo;

import kw.test.request.MerchantCategoryRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;

/**
 * auther   kangwang
 */
public interface MerchantCategoryService {

    ReturnValue save(MerchantCategoryRequest merchantCategoryRequest);

    ReturnValue delete(String id);

    ReturnValue edit(MerchantCategoryRequest merchantCategoryRequest);

    ReturnListValue findAll();
}
