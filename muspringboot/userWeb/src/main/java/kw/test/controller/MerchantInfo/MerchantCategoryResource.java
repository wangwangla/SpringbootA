package kw.test.controller.MerchantInfo;

import kw.test.request.MerchantCategoryRequest;
import kw.test.response.UserResponse;
import org.springframework.web.bind.annotation.*;

/**
 * auther   kangwang
 * 20187/14
 */
@RequestMapping("/merchancategory")
public interface MerchantCategoryResource {

    @PostMapping("/save")
    UserResponse saveMerchanCategory(@RequestBody MerchantCategoryRequest merchantCategoryRequest);

    @PutMapping("delete/{id}")
    UserResponse deleteMerchanCategory(@RequestBody String id);

    @PostMapping("/edit")
    UserResponse updateMerchanCategory(@RequestBody MerchantCategoryRequest merchantInfoRequest);

    @GetMapping("/findAll")
    UserResponse findAll();
}
