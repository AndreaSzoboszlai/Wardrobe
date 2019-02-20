package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private boolean notFull;
    private List<Cloth> cloths;

    public Hanger() {
        this.notFull = true;
        cloths = new ArrayList<Cloth>();
    }

    public void addSingleCloth(Cloth cloth) {
        cloths.add(cloth);
    }

    public void setEmpty(boolean empty) {
        this.notFull = empty;
    }

    public void removeSingleCloth(Cloth cloth) {
        cloths.remove(cloth);
    }

    public void removeAllClothes() {
        cloths = null;
        notFull = true;
    }

    public boolean getEmpty() {
        return notFull;
    }

    public List<Cloth> getCloths() {
        return cloths;
    }
}
