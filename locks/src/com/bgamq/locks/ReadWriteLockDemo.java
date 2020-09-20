package com.bgamq.locks;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class TicketDemo{

    private volatile Map<String,Object> map=new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public void putD(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"写入数据");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t"+"写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }



    }

    public void getD(String key){

        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"读入数据");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t"+"读入完成"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }



    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        TicketDemo demo = new TicketDemo();

        for (int i = 0; i <5 ; i++) {
            final int temId=i;
            new Thread(()->{
                demo.putD(String.valueOf(temId),temId);
            },String.valueOf(i)).start();
        }

        for (int i = 0; i <5 ; i++) {
            final int temId=i;
            new Thread(()->{
                demo.getD(String.valueOf(temId));
            },String.valueOf(i)).start();
        }

    }

}
