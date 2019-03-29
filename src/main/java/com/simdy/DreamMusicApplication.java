package com.simdy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.simdy.cms.mapper")
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class DreamMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamMusicApplication.class, args);
    }

}
