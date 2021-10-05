package com.zh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WisdomLyApplication {

    public static void main(String[] args) {
        log.info("springboot开始加载");
        SpringApplication.run(WisdomLyApplication.class, args);
        log.info("springboot加载完毕");
    }

}
