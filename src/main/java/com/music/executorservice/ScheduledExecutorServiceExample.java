package com.music.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ScheduledExecutorServiceExample {

    public static void main(String... args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        //任务延迟10秒运行
        executorService.schedule(new Task(), 10, TimeUnit.SECONDS);

        //任务每10秒运行一次
        executorService.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        //任务在前一任务完成10秒后重复运行
        executorService.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);
    }

    static class Task implements Runnable {
        public void run() {
        }
    }
}
