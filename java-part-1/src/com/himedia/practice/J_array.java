package com.himedia.practice;

public class J_array {
    public static void exam1(){
        int[] score = {10,20,30};
        System.out.println(score.length);
        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);

        }
    }
    public static void exam2(){
        char[] world ={'h','e','l','l','o'};
        for(char c : world){
            System.out.println(c);
        }
    }
    public static int exam6(int[] score, int num){
        score[1] = 90;
        num = 90;
        return num;
    }

    public static void exam6_1(){
        int[] score = {10, 20, 30};
        int num = 20;

        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }
        System.out.println(num);
        System.out.println("===============");
        num=exam6(score, num);//호출

        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }
        System.out.println(num);

    }
    public static void main(String[] args) {
        exam6_1();
    }
}
