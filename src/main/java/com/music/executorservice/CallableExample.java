package com.music.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> allFutures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Future<Integer> future = executor.submit(new Task());
            allFutures.add(future);
        }

        try {
            for (int i = 0; i < 100; i++) {
                Future<Integer> future=allFutures.get(i);
                Integer result = future.get();
                System.out.println("Result of future #"+i+"="+result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt(10);
        }
    }
}
