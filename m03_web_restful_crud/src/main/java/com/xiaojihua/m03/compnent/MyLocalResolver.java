package com.xiaojihua.m03.compnent;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义一个LocalResolver来覆盖springboot自定义的localResolver.
 * 通过判断请求链接中的l参数来设置Local
 */
public class MyLocalResolver implements LocaleResolver {

    /**
     * 根据l参数来设置local
     * 如果l参数为空则设置成系统默认local（系统默认local不以浏览器的语言而变化）
     * 也可以借鉴springboot默认local设置，即根据请求头来判断。
     * @param httpServletRequest
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
