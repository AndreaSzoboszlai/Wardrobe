package com.codecool;

public class NoSuchHangerException extends Exception {
    public NoSuchHangerException() {
        super("There is no hanger with an identifier like that.");
    }
}
