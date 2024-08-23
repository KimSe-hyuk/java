package com.himedia.java;

public class H_loop {

    //for문
    /*
        for(초기값; 조건식; 증감식){
            //조건이 참일 때 수행될 문장을 적는다.
        }
     */
    public  static  void  exam1(){
        for (int i= 0; i<10; ++i){
            System.out.println(i);
        }
    }

    public  static  void  exam2(){
        System.out.println("==== 구구단 2단 ====");
        for (int i= 0; i<10; i++){
            System.out.println("2 * " + i + " = " + i*2);
        }
    }

    public  static  void  exam3(){
        System.out.println("==== 구구단 전체 ====");
        for (int i= 0; i<10; i++){
            System.out.printf("== %d 단==\n",i);
            for (int j = 1; j < 10; j++) {
                System.out.println(i+" * " + j + " = " + i*j);
            }
        }
    }
    public  static  void  exam4(){
        System.out.println("짝수만 출력하기");
        for (int i= 0; i<10; i++){
            if(i%2!=0){
               continue;
            }
            System.out.println(i);
        }
    }
    public  static  void  exam5(){
        System.out.println("원하는 조건 멈추기");
        for (int i= 0; i<10; i++){
            if(i==5)continue;

            System.out.println(i);
        }
    }
    public  static  void  exam7(){
        for (int i= 0; i<10; i++){
            System.out.println("-첫 번째 루프 : " + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("--두 번째 루프 : " + i);
                for (int k = 0; k < 10; k++) {
                    System.out.println("---세 번째 루프 : " + i);
                }
            }

        }
    }

    public static void exam8() {
        int i = 0;
        for ( ; i < 10; ) {
            System.out.println(i++);
        }
    }
    public  static  void  exam9(){
        int i  =0;
        for (;;) {
            if( i>10)break;
            System.out.println(++i);
        }
    }

    public static void exam10(){
        //무한루프
        int i =0 ;
        for (;true;){
            System.out.println(i++);
        }
    }
    public static void exam11(){
        for (int i = 0; i < 10; i--) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        exam8();
    }
}
