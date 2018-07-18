package kw.test.controller.MerchantInfo;

import kw.test.request.MerchantInfoRequest;
import kw.test.response.UserResponse;
import org.springframework.web.bind.annotation.*;

/**
 * auther   kangwang
 * 2018/7/11
 */
@RequestMapping("/merchantInfo")
public interface MerchantInfoResource {

    @PostMapping("/save")
    UserResponse saveMerchantInfo(@RequestBody MerchantInfoRequest merchantInfoRequest);

    @PutMapping("delete/{id}")
    UserResponse deleteMerchantInfo(@RequestBody String id);

    @PostMapping("/edit")
    UserResponse updateMerchantInfo(@RequestBody MerchantInfoRequest merchantInfoRequest);

    @GetMapping("/findAll")
    UserResponse findAll();

    @GetMapping("/findByname")
    UserResponse findByName(String username);
}

