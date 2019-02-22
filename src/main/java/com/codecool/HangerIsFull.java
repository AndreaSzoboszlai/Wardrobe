package com.codecool;

public class HangerIsFull extends Exception {

    public HangerIsFull() {
        super("The Hanger is already full");
    }
}
