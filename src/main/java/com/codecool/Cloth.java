package com.codecool;

public abstract class Cloth {
    private String brand;
    private boolean onHanger;

    public Cloth (String brand) {
        this.brand = brand;
        this.onHanger = false;
    }

    public String getBrand() {
        return brand;
    }

    public void putOnHanger() {
        onHanger = true;
    }

    public void removeFromHanger() {onHanger = false;}

    public boolean onHanger() {
        return onHanger;
    }
}
