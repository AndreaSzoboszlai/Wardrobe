package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private List<Hanger> hangers;
    private int size;

    public Wardrobe(int size) {
        hangers = new ArrayList<Hanger>();
        this.size = size;
    }

    public void addHanger(Hanger hanger) {
        if (hangers.size() < size) {
            hangers.add(hanger);
        }
    }

    public List<Hanger> getHangers() {
        return hangers;
    }
}
