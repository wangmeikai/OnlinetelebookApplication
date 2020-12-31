package com.wmk.onlinetelebook.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceImplTest {

    @Autowired
    LoginServiceImpl loginService;

    @Test
    void loginIn() {
        boolean wmk = loginService.loginIn("wmk", "123456");
        System.out.println(wmk?"登录成功":"登录失败");
    }

    @Test
    void addUser() {
    }
}