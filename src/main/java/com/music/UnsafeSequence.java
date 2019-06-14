package com.music;

public class UnsafeSequence {
    private int count;

    public void calculate() {
        count += 1;
    }

    public int getCount() {
        return count;
    }
}
