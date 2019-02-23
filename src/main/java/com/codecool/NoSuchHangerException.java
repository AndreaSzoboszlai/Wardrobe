package com.codecool;

public class NoSuchHanger extends Exception {
    public NoSuchHanger() {
        super("There is no hanger with an identifier like that.");
    }
}
