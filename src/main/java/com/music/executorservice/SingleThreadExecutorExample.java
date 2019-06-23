package com.music.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
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
