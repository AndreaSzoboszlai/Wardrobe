package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private List<Hanger> hangers;
    private int maxSize;

    public Wardrobe(int maxSize) {
        this.hangers = new ArrayList<Hanger>();
        this.maxSize = maxSize;
    }

    public void addHanger(Hanger hanger) {
        if (hangers.size() < maxSize) {
            hangers.add(hanger);
        }
    }

    public List<Hanger> getHangers() {
        return hangers;
    }
}
