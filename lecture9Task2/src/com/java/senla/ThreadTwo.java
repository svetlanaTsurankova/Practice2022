package com.java.senla;

public class ThreadTwo implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("My name is : ThreadTwo");
        }
    }
}
