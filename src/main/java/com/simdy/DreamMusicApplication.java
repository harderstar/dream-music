package com.simdy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.simdy.cms.mapper")
@SpringBootApplication
public class DreamMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamMusicApplication.class, args);
    }

}
