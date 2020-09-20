package com.bgamq.locks;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * list集合的不安全
 *  java.util.ConcurrentModificationException
 *
 *  1、解决方法：
 *
 */


public class NotList {

    public static void main(String[] args) {

        List list=new  CopyOnWriteArrayList(); //Collections.synchronizedList(new ArrayList<>());//new Vector();//new ArrayList();

        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },"A").start();
        }





    }
}
