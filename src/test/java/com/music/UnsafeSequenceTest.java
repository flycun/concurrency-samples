package com.music;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class UnsafeSequenceTest
{
    @Test
    @Ignore
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(3);

        UnsafeSequence unsafeSequence = new UnsafeSequence();
        IntStream.range(0, 1000)
                .forEach(count -> service.submit(unsafeSequence::increamentCount));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, unsafeSequence.getCount());
    }
}
