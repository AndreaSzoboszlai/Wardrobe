package com.codecool;

public class BottomCloth extends Cloth {
    private BottomType bottomtype;

    public BottomCloth(String brand, BottomType bottomtype) {
        super(brand);
        this.bottomtype = bottomtype;
    }

    public BottomType getBottomtype() {
        return bottomtype;
    }

    @Override
    public String toString() {
        return "Type: " + bottomtype + ", Brand:  " + getBrand() + ", On hanger: " + onHanger();
    }
}
