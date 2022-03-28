package com.java.senla;

public class Test {
    public static void main(String[] args) {
        Info info = new Info();
        ProducerThread producerThread = new ProducerThread(info);
        ConsumerThread consumerThread = new ConsumerThread(info);
        new Thread(producerThread).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(consumerThread).start();
    }
}
