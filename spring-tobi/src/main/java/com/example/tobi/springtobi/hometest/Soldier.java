package com.example.tobi.springtobi.hometest;

public class Soldier {

    void runContext(String weaponSound){
        System.out.println("전투시작");
        executeWeapon(weaponSound).runStrategy();
        System.out.println("전투종료");
    }

    private Strateegy executeWeapon(final String weaponSound){
        return new Strateegy() {

            @Override
            public void runStrategy() {
                System.out.println(weaponSound);
            }
        };
    }
}
