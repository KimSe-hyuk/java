package com.himeda.practice;

public class protectedModifier {
    protected protectedModifier(int protectedVariable) {
        this.protectedVariable = protectedVariable;
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }
    protected int protectedVariable = 10;

}