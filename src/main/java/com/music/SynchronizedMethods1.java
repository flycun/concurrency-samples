package com.music;

public class SynchronizedMethods1 {
    private int syncSum = 0;
    static int staticSum = 0;

    // 修饰非静态方法
    void syncCalculate() {
        synchronized (this) {
            syncSum += 1;
        }
    }

    // 修饰静态方法
    static void syncStaticCalculate() {
        synchronized (SynchronizedMethods.class) {
            staticSum = staticSum + 1;
        }
    }

}


