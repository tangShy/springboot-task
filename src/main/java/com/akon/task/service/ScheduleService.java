package com.akon.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(cron = "0/5 * * * * *") // 每隔5秒执行一次hello方法
    public void hello() {
        System.out.println("你好！");
    }
}
