package kw.test.service.merchantinfo.impl;

import kw.test.dao.merchant.MerchantCategoryRepository;
import kw.test.domain.merchant.MerchantCategory;
import kw.test.domain.merchant.MerchantInfo;
import kw.test.excepton.ArgumentNullExceptionHandler;
import kw.test.excepton.UserException;
import kw.test.msg.UserMsg;
import kw.test.request.MerchantCategoryRequest;
import kw.test.request.MerchantInfoRequest;
import kw.test.response.ReturnListValue;
import kw.test.response.ReturnValue;
import kw.test.response.tools.CookieUtils;
import kw.test.service.merchantinfo.MerchantCategoryService;
import kw.test.service.merchantinfo.MerchantInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * auther   kangwang
 */
@Service
public class MerchantCategoryServiceImpl implements MerchantCategoryService {

    @Autowired private MerchantCategoryRepository merchantCategoryRepository;

    @Autowired private RedisTemplate<String,Object> redisTemplate;

    @Override
    public ReturnValue save(MerchantCategoryRequest merchantCategoryRequest) {
        ArgumentNullExceptionHandler.checkArgument(merchantCategoryRequest);
        /*创建merchantcategory*/
        MerchantCategory merchantCategory = new MerchantCategory();
        ReturnValue returnValue = new ReturnValue();
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        Cookie cookie = CookieUtils.get(request, "token");
        if(cookie == null) {
            returnValue.setMsg(UserMsg.USER_LOGIN_DEFAULT.getMsg());
            return returnValue;
        }
        MerchantInfo merchantInfo = (MerchantInfo) redisTemplate.opsForValue().get(cookie.getValue());
        String merchantCategoryId = merchantInfo.getId();
        //首先查找，是否含有，不可以添加重复的数据
        MerchantCategory merchantCategory1 = merchantCategoryRepository.findMerchantCategoryByCategoryAndMerchantId(merchantCategoryRequest.getCategory(),merchantCategoryId);
        if(merchantCategory1!=null) {
            returnValue.setMsg(UserMsg.USER_EXITS_AREADY.getMsg());
            return returnValue;
        }
        /*没有的时候，将请求数据变为merchantcategory*/
        BeanUtils.copyProperties(merchantCategoryRequest,merchantCategory);
        //设置时间
        merchantCategory.setCreateTime(new Date());
        //设置id值
        merchantCategory.setMerchantId(merchantCategoryId);
        merchantCategoryRepository.save(merchantCategory);
        returnValue.setMsg(UserMsg.USER_SAVE_SUCCESS.getMsg());
        returnValue.setObject(merchantCategory);
        return returnValue;
    }

    @Override
    public ReturnValue delete(String id) {
        ArgumentNullExceptionHandler.checkArgument(id);

        ReturnValue returnValue = new ReturnValue();
        //删除之前先将数据差一下，是否函有数据，有了在执行删除操作
        MerchantCategory merchantCategory = merchantCategoryRepository.findById(id).get();
        if (merchantCategory==null) {
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(id);
        }
        merchantCategoryRepository.delete(merchantCategory);
        returnValue.setObject(merchantCategory);
        returnValue.setMsg(UserMsg.USER_DELETE_SUCCESS.getMsg());
        return returnValue;
    }

    @Override
    public ReturnValue edit(MerchantCategoryRequest merchantCategoryRequest) {
        ArgumentNullExceptionHandler.checkArgument(merchantCategoryRequest);

        ReturnValue returnValue = new ReturnValue();
        MerchantCategory merchantCategory = merchantCategoryRepository.findById(merchantCategoryRequest.getId()).get();
        if(merchantCategory == null){
            returnValue.setMsg(UserMsg.USER_NOT_FOUND.getMsg());
            returnValue.setObject(merchantCategory);
            return returnValue;
        }
        returnValue.setMsg(UserMsg.USER_UPDATA_SUCCESS.getMsg());
        returnValue.setObject(merchantCategory);
        return returnValue;
    }

    @Override
    public ReturnListValue findAll() {
        List<MerchantCategory> merchantCategoryList =  merchantCategoryRepository.findAll();
        ReturnListValue returnListValue = new ReturnListValue();
        returnListValue.setObject(merchantCategoryList);
        return returnListValue;
    }
}
