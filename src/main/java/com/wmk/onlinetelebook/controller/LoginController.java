package com.wmk.onlinetelebook.controller;


import com.wmk.onlinetelebook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping({"/", "/login", "/login.html"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/main"})
    public String main() {
        return "main";
    }

    @PostMapping({"/loginIn"})
    public void loginIn(HttpServletRequest request, HttpServletResponse response, String userName, String pwd) throws ServletException, IOException {
        boolean isLogin = loginService.loginIn(userName, pwd);
        if (isLogin){
            request.getSession().setAttribute("userName",userName);
            response.addCookie(new Cookie("userName",userName));
            response.sendRedirect("/main");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            //post请求可以 重定向 到get请求上
            //post请求不能 转发 到get请求上
            //response.sendRedirect("/login");
            request.getRequestDispatcher("/login").forward(request,response);
        }
    }

    @GetMapping({"/loginOut"})
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("userName");
        request.setAttribute("msg","登出成功");
        request.getRequestDispatcher("/login").forward(request, response);

    }
}
