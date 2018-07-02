package com.example.ahn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.ahn")
public class AhnApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhnApplication.class, args);
    }
}
