package com.music;

public class ThreadExample {
    private int count = 0;
    public int getCount() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            // 主线程调用 thread1.start() 之前，所有对共享变量的修改，此处皆可见
            count += 1;
        });

        count = 10; // 此处对共享变量 count 修改
        thread1.start(); // 主线程启动子线程
        thread1.join();
        // 子线程所有对共享变量的修改, 在主线程调用 thread1.join() 之后皆可见
        return count;
    }
}
