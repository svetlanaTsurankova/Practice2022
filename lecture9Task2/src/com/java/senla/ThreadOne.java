package com.java.senla;

public class ThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("My name is : ThreadOne");
        }
    }
}
