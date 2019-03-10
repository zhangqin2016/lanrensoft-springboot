package com.lanrensoft;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@MapperScan("com.lanrensoft.*.mapper")
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("《《《《《《感谢您的支持与使用》》》》》》");
        log.info("《《《《《《lanrensoft started up successfully at {} {} 》》》》》》", LocalDate.now(), LocalTime.now());
    }
}
