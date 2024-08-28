package com.himedia.java;

import java.util.Scanner;

public class I2_vending_machine {
    static final int COKE = 500, CIDER = 700, FANTA = 300, WATER = 200;
    private static int balance = 0;
    private static int printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]콜라 500 [2]사이다 300 [3]환타 700 [4]물 200 [5]돈넣기 [6]반환");
        System.out.println("잔액 : "+balance);
        return sc.nextInt();
    }
    private  static void Choice(String cheDrink,int choince){
        if(balance-choince<0){
            System.out.println("잔액 부족");
        }else {
            balance-=choince;
            System.out.println(cheDrink + "나옴 , 잔액"+balance);
        }
    }
    private  static void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("돈 넣기");
        balance +=sc.nextInt();
    }
    public static void main(String[] args) {

        while (true) {
            int choiceNum = printMenu();
            switch (choiceNum) {
                case 1:
                    Choice("콜라", COKE);
                    break;
                case 2:
                    Choice("사이다", CIDER);
                    break;
                case 3:
                    Choice("환타", FANTA);
                    break;
                case 4:
                    Choice("물", WATER);
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    ReturnMoney();
                    return;
                default:
                    System.out.println("잘못누름");
                    break;
            }
        }
    }

    private static void ReturnMoney() {
        System.out.println("남은 돈은"+balance);
    }
}
