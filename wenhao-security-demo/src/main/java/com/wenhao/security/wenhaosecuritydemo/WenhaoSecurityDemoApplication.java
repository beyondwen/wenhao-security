package com.wenhao.security.wenhaosecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class WenhaoSecurityDemoApplication {

    /**
     * 主程序
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WenhaoSecurityDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello spring security";
    }
}
