package com.java.senla;

public class ConsumerThread implements Runnable {
    private Info info;

    public ConsumerThread(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.info.takeFromBuffer();
        }
    }
}
