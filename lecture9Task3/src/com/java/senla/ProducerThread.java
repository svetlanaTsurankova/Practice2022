package com.java.senla;

import java.util.Random;

public class ProducerThread implements Runnable {
    private Info info;

    public ProducerThread(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            this.info.addValueBuffer(random.nextInt(50));
        }
    }
}

