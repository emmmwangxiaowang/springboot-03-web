package com.wang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */
public class LoginHandlerInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {

        //登录成功后,应该由用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null)
        {
            //没有登陆
            request.setAttribute("message", "没有登录,请登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else
        {
            //return true 放行
            return true;

        }

    }
}
