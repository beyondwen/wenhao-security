package com.wenhao.security.wenhaosecuritydemo.config;


import com.wenhao.security.wenhaosecuritydemo.filter.TimeFilter;
import com.wenhao.security.wenhaosecuritydemo.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override//注册异步请求的拦截器
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //super.configureAsyncSupport(configurer);
    }

    //@Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter filter = new TimeFilter();
        filterRegistrationBean.setFilter(filter);
        List<String> url = new ArrayList<>();
        url.add("/*");
        filterRegistrationBean.setUrlPatterns(url);
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(timeInterceptor);
    }
}
