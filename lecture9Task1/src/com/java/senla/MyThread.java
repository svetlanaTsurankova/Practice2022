package com.java.senla;

public class MyThread implements Runnable {

    public void run() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }
    }
}
