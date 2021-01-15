package com.wmk.onlinetelebook.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceImplTest {

    private static LoginServiceImpl loginService;

    @BeforeAll
    static void init(){
        System.out.println("初始化。。所有测试方法前执行（一次）");
        loginService = new LoginServiceImpl();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("前置方法。。每个测试方法前执行（n次）");
    }

    @Test
    void loginIn() {
        boolean wmk = loginService.loginIn("wmk", "123456");
        System.out.println(wmk?"登录成功":"登录失败");
    }

    @Test
    void addUser() {
    }
}