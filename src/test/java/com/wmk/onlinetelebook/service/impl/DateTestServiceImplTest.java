package com.wmk.onlinetelebook.service.impl;

import com.wmk.onlinetelebook.pojo.DateTest;
import com.wmk.onlinetelebook.service.impl.DateTestServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

class DateTestServiceImplTest {

    private static DateTestServiceImpl dateTestService;

    @BeforeAll
    static void init(){
        System.out.println("初始化。。所有测试方法前执行（一次）");
        dateTestService = new DateTestServiceImpl();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("前置方法。。每个测试方法前执行（n次）");
    }

    @Test
    void testInsertTime() {
        DateTest dateTest = new DateTest(LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
        int i = dateTestService.insertTime(dateTest);
        System.out.println(i);
        System.out.println(dateTest);
    }
}