package com.music.locks;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeSequenceWithoutLock {

    private final AtomicInteger counter = new AtomicInteger(0);
    
    public int getCount() {
        return counter.get();
    }
    
    public void increamentCount() {
        while(true) {
            int existingValue = getCount();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }
}