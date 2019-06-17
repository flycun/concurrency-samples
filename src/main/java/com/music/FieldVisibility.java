package com.music;

public class FieldVisibility {
    volatile int x=0;
    public void writerThread(){
        x=1;
    }
    public void readerThread(){
        int r=x;
    }
}
