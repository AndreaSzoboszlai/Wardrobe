package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private List<Hanger> hangers;
    private int maxSize;
    private List<Cloth> createdClothes;

    public Wardrobe(int maxSize) {
        this.hangers = new ArrayList<>();
        this.maxSize = maxSize;
        this.createdClothes = new ArrayList<>();
    }

    public void addHanger(Hanger hanger) {
        if (hangers.size() < maxSize) {
            hangers.add(hanger);
        }
    }

    public void createdList(Cloth cloth) {
        createdClothes.add(cloth);
    }

    public List<Hanger> getHangers() {
        return hangers;
    }

    public List<Cloth> getCreatedClothes() {
        return createdClothes;
    }
}
