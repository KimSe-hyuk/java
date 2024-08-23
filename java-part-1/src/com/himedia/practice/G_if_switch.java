package com.himedia.practice;

import java.util.Scanner;

public class G_if_switch {

    public static void exam1(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        switch (score){
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            case 4:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }

    }
    public static void main(String[] args) {

    }
}
