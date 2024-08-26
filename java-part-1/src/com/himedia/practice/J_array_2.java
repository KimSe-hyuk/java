package com.himedia.practice;

public class J_array_2 {

    public static void exam1(){
        int[][] score = new int[3][2];
        score[0][0] = 1;
        score[0][1] = 2;
        score[1][0] = 3;
        score[1][1] = 4;
        score[2][0] = 5;
        score[2][1] = 6;
        for (int row = 0; row < score.length; row++) {
            for(int col = 0; col < score[row].length; col++){
                System.out.print(score[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void exam2(){
        int[][] score = {{1,2},{2,3},{4,5}};

        for(int[] sc : score){
            System.out.println(sc);
            for(int s : sc){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    public static void exam3(){
        int[][] score = new int[3][];

        score[0] = new int[]{1, 2};
        score[1] = new int[3];
        score[2] = new int[4];

        score[1][0] = 3;
        score[1][1] = 4;
        score[1][2] = 5;

        score[2][0] = 6;
        score[2][1] = 7;
        score[2][2] = 8;
        score[2][3] = 9;

        for (int row = 0; row < score.length; row++) {
            for (int col = 0; col < score[row].length; col++) {
                System.out.print(score[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

    }
}
