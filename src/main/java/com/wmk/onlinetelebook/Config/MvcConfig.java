package com.wmk.onlinetelebook.Config;


import com.wmk.onlinetelebook.intercept.GlobalIntercept;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalIntercept()).addPathPatterns("/**")
                .excludePathPatterns("/login","/","/loginIn","/regist","/registUser","/**/*.css");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/")
//                .setViewName("");
    }
}
