package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@MapperScan(basePackages = "com.example.mapper")
@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean//将密码加密器存放到Spring容器中来管理 @Bean 需要在配置类中使用
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
