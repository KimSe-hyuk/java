package com.himeda.practice;

public class privateModifier {
    protected privateModifier(int privateModifier) {
        this.privateVariable = privateModifier;
    }

    protected void privateMethod() {
        System.out.println("privateMethod");
    }
    protected int privateVariable = 20;
}
