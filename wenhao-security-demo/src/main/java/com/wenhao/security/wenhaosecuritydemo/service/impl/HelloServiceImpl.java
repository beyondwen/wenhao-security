package com.wenhao.security.wenhaosecuritydemo.service.impl;

import com.wenhao.security.wenhaosecuritydemo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String gretting(String name) {
        System.out.println("gretting");
        return "hello" + name;
    }
}
