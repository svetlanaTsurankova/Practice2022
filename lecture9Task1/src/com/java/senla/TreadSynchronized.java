package com.java.senla;

public class TreadSynchronized implements Runnable {
    private static Object obj = new Object();

    public void run() {
        try {
            synchronized (obj) {
                obj.wait();
            }
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
    }

    public static Object getObj() {
        return obj;
    }
}
