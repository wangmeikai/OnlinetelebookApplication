package com.wmk.onlinetelebook.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("容器启动。。。。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
    }

    @Override
    public void destroy() {
        System.out.println("项目关闭。。。。。。。");
    }
}
