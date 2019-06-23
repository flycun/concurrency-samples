package com.music.executorservice;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.start();
        System.out.println("Thread Name:" + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread Name:" + Thread.currentThread().getName());
        }
    }
}
