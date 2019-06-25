package com.music.other;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SafeSequence {
    private final Lock rtl = new ReentrantLock();
    private int count;
    public void increamentCount() {
        rtl.lock();
        try {
            count = 1 + getCount(); //①
        } finally {
            rtl.unlock();
        }
    }

    public int getCount() {
        rtl.lock();                  // ②
        try {
            return count;
        } finally {
            rtl.unlock();
        }
    }
}
