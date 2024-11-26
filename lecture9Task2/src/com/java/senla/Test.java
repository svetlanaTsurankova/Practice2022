package com.java.senla;

public class Test {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        threadOne.start();
        threadTwo.start();
        if (threadOne.isAlive()) {
            try {
                threadOne.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
