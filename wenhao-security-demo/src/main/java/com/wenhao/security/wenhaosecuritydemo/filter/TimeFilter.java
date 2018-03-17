package com.wenhao.security.wenhaosecuritydemo.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/*@Component*/
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timefileter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long startTime = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("time filter 耗时" + (new Date().getTime() - startTime));
        System.out.println("time filter finsh");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destory");
    }
}
