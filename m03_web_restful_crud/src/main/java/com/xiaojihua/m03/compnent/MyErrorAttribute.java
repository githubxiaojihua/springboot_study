package com.xiaojihua.m03.compnent;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    /**
     * 在原有的ErrorAttributes上增加我们自定义的属性
     * @param webRequest
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        //获取原来的ErrorAttributes
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("myError","自定义的错误数据");
        //获取我们自定义异常处理器往request中设置的错误数据，第二个参数scope指的是从request中获得
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
