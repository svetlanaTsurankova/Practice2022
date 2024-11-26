package com.java.senla;

public class Test {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread(2000));
        myThread.setDaemon(true);
        System.out.println(myThread.isDaemon());
        myThread.run();
    }
}
