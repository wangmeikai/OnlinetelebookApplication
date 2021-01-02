package com.wmk.onlinetelebook.service;

import com.wmk.onlinetelebook.pojo.DateTest;
import com.wmk.onlinetelebook.service.impl.DateTestServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class DateTestServiceImplTest extends DateTestServiceImpl {

    @Test
    void testInsertTime() {
        DateTest dateTest = new DateTest(LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
        int i = super.insertTime(dateTest);
        System.out.println(i);
        System.out.println(dateTest);
    }
}