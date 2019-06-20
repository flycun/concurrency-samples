package com.music;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class SafeSequenceTest
{
    @Test
    public void givenMultiThread_whenSyncMethod() throws InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(3);

        SafeSequence safeSequence = new SafeSequence();
        IntStream.range(0, 1000)
                .forEach(count -> service.submit(safeSequence::increamentCount));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, safeSequence.getCount());
    }
}
