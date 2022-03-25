package com.java.senla;

import java.util.LinkedList;
import java.util.List;

public class Info {
    private static final int BUFFER_MAX_SIZE = 40;
    private List<Integer> buffer = new LinkedList<>();

    public synchronized void addValueBuffer(int value) {
        while (buffer.size() == BUFFER_MAX_SIZE) {
            try {
                wait();
                System.out.println(" wait a ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.add(value);
        System.out.println(" value  " + value);
        notify();
    }

    public synchronized int takeFromBuffer() {
        while (buffer.size() == 0) {
            try {
                wait();
                System.out.println(" wait  t ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int result = buffer.remove(0);
        System.out.println(" result  " + result);
        notify();
        return result;
    }
}
