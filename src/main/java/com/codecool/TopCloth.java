package com.codecool;

public class TopCloth extends Cloth {
    private TopType topType;

    public TopCloth(String brand, TopType type) {
        super(brand);
        this.topType = type;
    }

    public TopType getTopType() {
        return topType;
    }

    public String toString() {
        return "Type: " + topType + ", Brand:  " + getBrand() + ", On hanger: " + onHanger();
    }
}
