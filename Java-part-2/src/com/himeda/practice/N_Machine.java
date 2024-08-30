package com.himeda.practice;

import java.util.Scanner;

    public class N_Machine implements N_Vending {
    private int totalMoney =0;


    public boolean setTotalMoney(int totalMoney) {
        if(totalMoney<0){
            return false;
        }
        this.totalMoney = totalMoney;
        return true;
    }


    public int getTotalMoney() {
        return totalMoney;
    }

    @Override
    public void printMenu() {
        System.out.println("====================== 자판기 ======================");
        System.out.println("[1]콜라-500원 [2]사이다-700원 [3]환타-300원 [4]물-200원");
        System.out.println("[5]돈넣기 [6]반환");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("===================================================");
    }

    @Override
    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 메뉴를 선택하시오 -> ");

        return sc.nextInt();
    }

    @Override
    public void getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("돈을 넣으시오 -> ");
        totalMoney=totalMoney+sc.nextInt();
    }

    @Override
    public int calcMoney(int price) {
        return this.totalMoney - price;
    }

    @Override
    public void printException() {
        System.out.println("잔돈이 부족합니다.");
    }
}
