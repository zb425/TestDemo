package com.bgamq.locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的通信
 *
 *  判断/干活/通知
 *
 *  使用juc中的Condition中的await 和  signalAll来替代Object中的 wait和notifyAll
 */

class TicketSum{
    private int num=0;
    private Lock lock=new ReentrantLock();
    private java.util.concurrent.locks.Condition condition=lock.newCondition();

    /**
     * 使用synchronized解决线程之间的通信
     */
    /*public synchronized void sub(){
        while (num!=0){
            try {
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"  "+num);
        this.notifyAll();
    }*/
    /*public synchronized void des(){
        while (num==0){
            try {
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        num--;
        System.out.println(Thread.currentThread().getName()+"  "+num);
        this.notifyAll();
    }*/

    /**
     * 使用lock来解决线程之间的通信
     */
    public  void sub(){
        lock.lock();
        try {
            while (num!=0){
                try {
                    condition.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"  "+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public  void des(){

        lock.lock();
        try {
            while (num==0){
                try {
                    condition.await();//this.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            num--;
            System.out.println(Thread.currentThread().getName()+"  "+num);
            condition.signalAll();//this.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           lock.unlock();
        }

    }


}


public class Condition {
    public static void main(String[] args) {
        TicketSum sum = new TicketSum();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                sum.sub();
            }},"A").start();
        new Thread(()->{for (int i = 1; i <=10 ; i++) {
            sum.sub();
        }},"B").start();
        new Thread(()->{for (int i = 1; i <=10 ; i++) {
            sum.des();
        }},"C").start();
        new Thread(()->{for (int i = 1; i <=10 ; i++) {
            sum.des();
        }},"D").start();
    }
}
