package com.chengfurong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.chengfurong.mapper")
public class ForthshoppingbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForthshoppingbootApplication.class, args);
    }

}
