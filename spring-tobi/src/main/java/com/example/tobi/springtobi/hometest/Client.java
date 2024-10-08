package com.example.tobi.springtobi.hometest;

public class Client {
    public static void main(String[] args) {
        Soldier rambo = new Soldier();

        rambo.runContext("총");

        System.out.println();

        rambo.runContext("칼");
        System.out.println();

        rambo.runContext("도끼");
    }
}
