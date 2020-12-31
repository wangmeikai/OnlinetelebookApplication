package com.wmk.onlinetelebook.controller;


import com.wmk.onlinetelebook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterController {
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping({"/regist"})
    public String regist() {
        return "regist";
    }

    @GetMapping({"/registUser"})
    public void registUser(HttpServletResponse response, HttpServletRequest request, String userName, String pwd) throws ServletException, IOException {
        boolean registSuccess = loginService.addUser(userName, pwd);
        if (registSuccess){
            request.setAttribute("msg","注册成功");
            request.getRequestDispatcher("/login").forward(request,response);
        }else {
            request.setAttribute("msg","注册失败");
            request.getRequestDispatcher("/regist").forward(request,response);
        }
    }
}
