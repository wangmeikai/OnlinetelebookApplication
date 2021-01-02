package com.wmk.onlinetelebook.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalIntercept implements HandlerInterceptor {
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies==null){
            request.setAttribute("msg","请登录。。。");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        String userName = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")){
                userName = cookie.getValue();
            }
        }
        if (userName==null){
            request.setAttribute("msg","请登录。。。");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        String isLogin = stringRedisTemplate.opsForValue().get(userName);
        if (isLogin!=null){
            return true;
        }else {
            request.setAttribute("msg","请登录。。。");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    @Autowired
    public void setRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
