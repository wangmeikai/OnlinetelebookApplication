package com.wmk.onlinetelebook.controller;


import com.wmk.onlinetelebook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping({"/", "/login", "/login.html"})
    public String login() {
        return "login";
    }

    @GetMapping({"/main"})
    public String main() {
        return "main";
    }

    @PostMapping({"/loginIn"})
    public void loginIn(HttpServletRequest request, HttpServletResponse response, String userName, String pwd) throws ServletException, IOException {
        boolean canLogin = loginService.loginIn(userName, pwd);
        if (canLogin){
            stringRedisTemplate.opsForValue().set(userName,"isLogin",30,TimeUnit.MINUTES);
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
        Cookie[] cookies = request.getCookies();
        String userName = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")){
                userName = cookie.getValue();
            }
        }
        stringRedisTemplate.delete(userName);
        request.setAttribute("msg","登出成功");
        request.getRequestDispatcher("/login").forward(request, response);

    }
}
