package com.music;

class VolatileFeaturesExample {
    long vl = 0L;

    public synchronized void set(long l) {
        vl = l;
    }

    public void getAndIncrement() { //普通方法调用
        long temp = get();   //调用已同步的读方法
        temp += 1L;          //普通写操作
        set(temp);           //调用已同步的写方法
    }

    public synchronized long get() {
        return vl;
    }
}