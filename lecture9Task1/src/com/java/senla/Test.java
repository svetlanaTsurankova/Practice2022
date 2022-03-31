package com.java.senla;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyThread());
        Thread myThread2 = new Thread(new TreadSynchronized());
        System.out.println("state NEW :  " + myThread.getState());
        myThread.start();
        myThread2.start();
        System.out.println("state  RUNNABLE :  " + myThread2.getState());
        Thread.sleep(500L);
        System.out.println("state  WAITING :  " + myThread2.getState());
        Object obj = TreadSynchronized.getObj();
        synchronized (obj) {
            obj.notify();
        }
        System.out.println("state  BLOCKED :  " + myThread2.getState());
        System.out.println("state  TIMED_WAITING :  " + myThread.getState());
        Thread.sleep(500L);
        System.out.println("state  TERMINATED :  " + myThread2.getState());
    }
}