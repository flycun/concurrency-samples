package com.music.blockarray;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class BlockArrayTest {

    @Test
    public void blockArrayTest_withoutCondition() throws InterruptedException {
        final BlockingArray<Integer> blockingArray = new BlockingArray<Integer>(2);
        final AtomicInteger count = new AtomicInteger(-1);

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingArray.put(count.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingArray.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void blockArrayConditionTest() throws InterruptedException {
        final BlockingArrayWithCondition<Integer> blockingArray = new BlockingArrayWithCondition<Integer>(2);

        final AtomicInteger count = new AtomicInteger(-1);

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingArray.put(count.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingArray.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
