package com.shiki.springbootweb.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver  implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的l 参数
        String l = request.getParameter("l");

        //如果没有携带参数就使用默认的
        Locale locale =Locale.getDefault();
        if (!StringUtils.isEmpty(l))
        {
            String [] split=l.split("_");
            //取出国家和地区
          locale =  new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
