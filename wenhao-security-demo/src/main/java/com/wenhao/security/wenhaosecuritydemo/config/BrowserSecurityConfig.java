package com.wenhao.security.wenhaosecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        System.out.println("测试下是否打印");
    }
}
