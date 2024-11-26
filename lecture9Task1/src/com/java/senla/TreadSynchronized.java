package com.java.senla;

public class TreadSynchronized implements Runnable {
    private static final Object obj = new Object();

    public void run() {
        try {
            synchronized (obj) {
                obj.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Object getObj() {
        return obj;
    }
}
