package com.wmk.onlinetelebook.config;


import com.wmk.onlinetelebook.intercept.GlobalIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfig implements WebMvcConfigurer {

    private GlobalIntercept globalIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(globalIntercept).addPathPatterns("/**")
//                .excludePathPatterns("/login","/","/loginIn","/regist","/registUser","/**/*.css");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }


    @Autowired
    public void setGlobalIntercept(GlobalIntercept globalIntercept) {
        this.globalIntercept = globalIntercept;
    }
}
