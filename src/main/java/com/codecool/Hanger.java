package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private String name;
    private HangerType hangerType;
    private boolean haveClothOnIt;
    private List<Cloth> cloths;

    public Hanger(String name, HangerType hangerType) {
        this.name = name;
        this.hangerType = hangerType;
        this.haveClothOnIt = false;
        this.cloths = new ArrayList<Cloth>();
    }

    public void addSingleCloth(Cloth cloth) throws HangerIsFull {
        if (hangerType == HangerType.SINGLE) {
            if (cloths.size() < 1) {
                cloths.add(cloth);
            } else {
                throw new HangerIsFull();
            }
        } else if (hangerType == HangerType.DOUBLE) {
            if (haveClothOnIt == true) {
                if (cloth instanceof BottomCloth && (cloths.get(0) instanceof TopCloth)) {
                    cloths.add(cloth);
                    cloth.onHanger();
                } else if (cloth instanceof TopCloth && (cloths.get(0) instanceof BottomCloth)) {
                    cloths.add(cloth);
                    cloth.onHanger();
                }
                if (cloths.size() == 2) {
                    throw new HangerIsFull();
                }
            } else {
                cloths.add(cloth);
            }
        }
    }

    public void setEmpty(boolean empty) {
        this.haveClothOnIt = empty;
    }

    public void removeSingleCloth(Cloth cloth) {
        cloths.remove(cloth);
        haveClothOnIt = false;
        cloth.removeFromHanger();
    }

    public void removeAllClothes() {
        cloths.clear();
        haveClothOnIt = false;
        for (Cloth element : cloths) {
            element.removeFromHanger();
        }
    }

    public String getName() {
        return name;
    }

    public boolean getHaveClothOnIt() {
        return haveClothOnIt;
    }

    public List<Cloth> getCloths() {
        return cloths;
    }
}
