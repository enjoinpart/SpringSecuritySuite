package com.github.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.github.edu.mappers")
@ServletComponentScan(basePackages ="com.github.edu")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
