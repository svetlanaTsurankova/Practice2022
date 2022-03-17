package com.java.senla;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers = new ArrayList<Flower>();

    public Double costOfBouquet() {
        Double fullPrice = 0.0;
        for (int i = 0; i < flowers.size(); i++) {
            fullPrice += (flowers.get(i).getPrice());
        }
        return fullPrice;
    }

    public Bouquet addFlowerInBouquet(Flower flower) {
        flowers.add(flower);
        return this;
    }
}
