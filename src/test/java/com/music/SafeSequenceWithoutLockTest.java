package com.music;

import com.music.locks.SafeSequenceWithoutLock;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class SafeSequenceWithoutLockTest
{
    @Test
    public void givenMultiThread_whenSafeCounterWithoutLockIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SafeSequenceWithoutLock safeCounter = new SafeSequenceWithoutLock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(safeCounter::increamentCount));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, safeCounter.getCount());
    }
}
