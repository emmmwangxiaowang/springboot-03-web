package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpSession;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */

@Controller
public class LoginController
{
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model Model, HttpSession session)
    {

        //具体业务
        //账号不为空才进入。。。
        if (!StringUtils.isEmpty(username) && "123456".equals(password))
        {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else
        {
            System.out.println("=======" + username + "======" + password);
            //告诉用户登录失败
            Model.addAttribute("message", "用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index.html";
    }
}
