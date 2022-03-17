package com.java.senla;

public class Test {
    public static void main(String[] args) {
        Rouse rouse = new Rouse("Rouse", "red", 15.32);
        Chamomile chamomile = new Chamomile("Chamomile", "White", 17.45);
        Pion pion = new Pion("Pion", "pink", 25.00);
        Bouquet bouquet = new Bouquet();
        bouquet.addFlowerInBouquet(rouse).addFlowerInBouquet(chamomile).addFlowerInBouquet(pion);
        System.out.printf("%.2f", bouquet.costOfBouquet());
    }
}
