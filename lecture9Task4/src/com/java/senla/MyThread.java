package com.java.senla;

import java.util.Date;

public class MyThread implements Runnable {
    private int time = 20000;
    Thread thread = new Thread();

    public MyThread(int time) {
        this.time = time;
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            try {
                thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("System datetime  : " + date);
        }
    }
}
