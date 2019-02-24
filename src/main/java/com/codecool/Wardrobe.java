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

    public Hanger findHanger(Cloth cloth) throws NotOnHangerException {
        Hanger hanger = null;
        for (Hanger element : hangers) {
            for (Cloth element2 : element.getCloths()) {
                if (element2.getBrand().equals(cloth.getBrand())) {
                    hanger = element;
                }
            }
        }
        if (hanger == null) {
            throw new NotOnHangerException();
        }
        return hanger;
    }

    public Hanger findHangerByName(String hanger) throws NoSuchHanger {
        Hanger hanger1 = null;
        for (Hanger element : hangers) {
            if (element.getName().equals(hanger)) {
                hanger1 = element;
            }
        }
        if (hanger1 == null) {
            throw new NoSuchHanger();
        }
        return hanger1;
    }
}
