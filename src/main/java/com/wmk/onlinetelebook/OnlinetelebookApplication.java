package com.wmk.onlinetelebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.wmk.onlinetelebook.filter")
@MapperScan("com.wmk.onlinetelebook.mapper")
public class OnlinetelebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinetelebookApplication.class, args);
    }
}
