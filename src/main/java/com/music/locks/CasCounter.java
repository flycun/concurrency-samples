package com.music.locks;

public class CasCounter {
    // 一个模拟的 CAS 封装类
    private SimulatedCAS value;

    public int getValue() {
        // CAS 类含有一个 get() 返回当前值
        return value.get();
    }

    public int increment() {
        int v;

        // compareAndSwap() 可能返回的值有 v 或 v - 1 两种
        // 如果为 v - 1，那么继续重试
        // 如果为 v，则代表成功，停止重试
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));

        return v + 1;
    }
}
