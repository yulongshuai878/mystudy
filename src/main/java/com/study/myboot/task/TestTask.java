package com.study.myboot.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @program: myboot
 * @description:
 * @author: ShiYulong
 * @create: 2019-12-27 15:28
 **/
@Slf4j
@Service
public class TestTask {
    @Scheduled(cron = "*/10 * * * * ?")
    public void execute() {
        log.info("print word.");
        log.info(String.valueOf(System.currentTimeMillis()));
        try {
            Thread.sleep(2000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Scheduled(cron = "*/10 * * * * ?")
    public void execute1() {
        log.info(String.valueOf(System.currentTimeMillis()));
        log.info("write message.");
    }
}
