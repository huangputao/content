package com.example.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//扫描mybatis哪些包里面的接口
@MapperScan("com.example.content.mapper")
@SpringBootApplication
public class SpringcloudContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudContentApplication.class, args);
    }

}
