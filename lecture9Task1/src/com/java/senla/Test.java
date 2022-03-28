package com.java.senla;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyThread());
        Thread myThread2 = new Thread(new TreadSynchronized());
        System.out.println("state NEW :  " + ThreadState.state(myThread.getState()));
        myThread.start();
        myThread2.start();
        System.out.println("state  RUNNABLE :  " + ThreadState.state(myThread2.getState()));
        Thread.sleep(500L);
        System.out.println("state  WAITING :  " + ThreadState.state(myThread2.getState()));
        Object obj = TreadSynchronized.getObj();
        synchronized (obj) {
            obj.notify();
        }
        System.out.println("state  BLOCKED :  " + ThreadState.state(myThread2.getState()));
        System.out.println("state  TIMED_WAITING :  " + ThreadState.state(myThread.getState()));
        Thread.sleep(500L);
        System.out.println("state  TERMINATED :  " + ThreadState.state(myThread2.getState()));
    }
}