package com.music.locks;

public class SimulatedCAS {
    private int value;
    public synchronized int get() {
        return value;
    }
    /**
     * 如果期望值与原值相等，那么将新值覆盖原值
     * @param expectedValue 期望值，用来与原值比较
     * @param newValue 新值
     * @return 无论原值是否等于期望值，都将返回原值
     */
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
    /**
     * 是否替换成功
     */
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return (expectedValue == compareAndSwap(expectedValue, newValue));
    }
}
