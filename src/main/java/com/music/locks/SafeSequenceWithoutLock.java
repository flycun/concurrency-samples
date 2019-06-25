package com.music.locks;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeSequenceWithoutLock {

    private final AtomicInteger counter = new AtomicInteger(0);
    
    public int getCount() {
        return counter.get();
    }
    
    public void increamentCount() {
       counter.incrementAndGet();
    }
}