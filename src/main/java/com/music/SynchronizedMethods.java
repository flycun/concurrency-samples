package com.music;

public class SynchronizedMethods {
    private int syncSum = 0;
    static int staticSum = 0;
    // 修饰非静态方法
    synchronized void syncCalculate() {
        syncSum += 1;
    }
    // 修饰静态方法
    synchronized static void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    synchronized  int getSyncSum() {
        return syncSum;
    }
}

