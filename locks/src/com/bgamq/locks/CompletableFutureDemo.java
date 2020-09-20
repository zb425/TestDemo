package com.bgamq.locks;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        /*CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("nishi");
        });

        try {
            future.get();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

        System.out.println("completetable");*/

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "nihoa";
        });

        try {
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
