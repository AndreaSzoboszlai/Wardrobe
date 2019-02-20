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

    public boolean onHanger() {
        return onHanger;
    }
}
