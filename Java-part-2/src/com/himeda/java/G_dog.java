package com.himeda.java;

public class G_dog extends G_animal{
    public void bark(){
        System.out.println(name + " is barking");
    }
    int a=0;
    @Override
    public void walk() {
        System.out.println("우당탕탕~");
    }

}
