package com.example.tobi.announcement.controller;

public class start {
    public static void main(String[] args) {
        //one();
        //two();
        //three();
        //four();
        //five();
//        six();
//        seven();
       // eight();
        //nine();
       // ten();
        //eleven();
        //twelve();
        thirteen();
    }

    private static void thirteen() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            if(i<6){
                for (int k = 0; k < i; k++) {
                    System.out.print(" ");
                }
            }else{
                for (int k = 10; k > i; k--) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void twelve() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <5; j++) {
                System.out.print("*");
            }
            for (int j = i; j <4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {

            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void eleven() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <5; j++) {
                System.out.print("*");
            }
            for (int j = i; j <4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void ten() {
        for (int i = 0; i < 6; i++) {

            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void nine() {

            for (int i = 0; i < 9; i++) {
                for (int j = i; j < 10; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.print(" ");
                for (int j = i; j < 4; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        for (int i = 1; i <5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void eight() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    private static void seven() {
        for (int i = 0; i < 5; i++) {

            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    private static void six() {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void five() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void four() {
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i-1; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < 6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void three(){
        for (int i = 0; i < 5; i++) {
            for (int j = 5-i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void one(){
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void two(){
        for (int i = 1; i < 6; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
