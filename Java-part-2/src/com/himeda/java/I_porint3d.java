package com.himeda.java;

public class I_porint3d extends I_point{
    int z=30;

    public I_porint3d(){
        this(100,200,300);
        System.out.println("나는 자식이다.");
    }
    public I_porint3d(int x, int y, int z) {
        super(x, y);
        this.z=z;
    }
}
