package com.codecool;

public class NotOnHangerException extends Exception {
    public NotOnHangerException() {
        super("Cloth is not on a Hanger");
    }
}
