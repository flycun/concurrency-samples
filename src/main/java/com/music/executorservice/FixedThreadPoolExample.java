package com.music.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //提交任务
        for (int i = 0; i < 100; i++) {
            executor.execute(new Task());
        }
        System.out.println("Thread Name:"
                + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread Name:"
                    + Thread.currentThread().getName());
        }
    }
}
