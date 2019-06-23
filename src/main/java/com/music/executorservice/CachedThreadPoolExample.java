package com.music.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        //for lot of short lived tasks
        ExecutorService executor = Executors.newCachedThreadPool();
        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            executor.execute(new Task());
        }
    }

    static class Task implements Runnable {
        public void run() {
            //short lived task
        }
    }
}
