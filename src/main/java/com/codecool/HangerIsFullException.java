package com.codecool;

public class HangerIsFullException extends Exception {

    public HangerIsFullException() {
        super("The Hanger is already full");
    }
}