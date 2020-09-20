package com.bgamq.locks;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i <10; i++) {
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t"+"办理业务");
                });
               /* new Thread(()->{

                },Thread.currentThread().getName()).start();*/
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            poolExecutor.shutdown();
        }

       // System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
