package com.music;

class VolatileFeaturesExample1 {
    volatile long vl = 0L;

    public void set(long l) {
        vl = l;
    }

    public void getAndIncrement() {
        vl++;    //复合volatile变量的读/写
    }

    public long get() {
        return vl;
    }
}