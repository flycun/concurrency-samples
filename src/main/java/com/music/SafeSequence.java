package com.music;

public class SafeSequence {
    private int count;
    public synchronized void increamentCount() {
        count += 1;
    }
    public synchronized int getCount() {
        return count;
    }
}
