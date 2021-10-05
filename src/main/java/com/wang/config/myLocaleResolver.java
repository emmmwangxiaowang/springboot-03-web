package com.wang.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */

//自定义
public class myLocaleResolver implements LocaleResolver
{

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request)
    {

        //获取请求中的原参数
        String language = request.getParameter("l");
        //获取默认
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language))
        {
            System.out.println("=======>" + language);
            String[] split = language.split("_");
            //                   国家        语言
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale)
    {

    }
}
