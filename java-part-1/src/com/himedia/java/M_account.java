package com.himedia.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class M_account {
    // 계좌 사람 수
    static int accountNum = 1;

    private static void makeAccount(String[][] members){
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 입력 : ");
        members[accountNum -1][1]  = sc.nextLine();
        /*
        Set<Integer> set = new HashSet<>();

        while (set.size() < 5) {
            set.add((int) (Math.random() * 10));
        }
        StringBuilder numberBuilder = new StringBuilder();
        for (Integer digit : set) {
            numberBuilder.append(digit);
        }
        members[accountNum -1][0] = numberBuilder.toString();
        members[accountNum -1][2]="0";
        members[accountNum -1][3]="";
        System.out.println("계좌번호 : "+ members[accountNum -1][0]);*/

        boolean count =true;
        int num1 =0;
        int[] nums =new int[5];
        while (num1 < 5) {
            int a = (int) (Math.random() * 10);
            for (int i = 0; i < 5; i++) {
                if (nums[i] == a) {
                    count =false;
                    break;
                }
            }
            if (count) {
                nums[num1] = a;
                num1++;
            }
        }
        StringBuilder accountString = new StringBuilder();
        for (int digit : nums) {
            accountString.append(digit);
        }
        members[accountNum -1][0] = accountString.toString();
        System.out.println("계좌번호 : "+ members[accountNum -1][0]);
    }
    private  static int printSelect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]입금 [2]출금 [3]현재 금액 조회 [4]내역조회 [5]프로그램 종료");
        return sc.nextInt();
    }
    private static void depositMoney(String[][] members){
        Scanner sc = new Scanner(System.in);
        //계좌번호로 계좌 찾기
        System.out.println("계좌번호 입력");
        String account = sc.nextLine();

        for (int i = 0; i < accountNum; i++) {
            if(account.equals(members[i][0])){
                System.out.println("입급할 돈 입력 ");
                int money = sc.nextInt();
                members[i][2]= Integer.toString(money+Integer.parseInt(members[i][2]));
                System.out.println("입급완료");
                insertHistory(i,members,"[입급]",Integer.toString(money));
                return;
            }

        }
        System.out.println("계좌번호 틀림");

    }
    private static void withdrawMoney(String[][] members){
        Scanner sc = new Scanner(System.in);
        //계좌번호로 계좌 찾기
        System.out.println("계좌번호 입력");
        String account = sc.nextLine();

        for (int i = 0; i < accountNum; i++) {
            if(account.equals(members[i][0])){
                System.out.println("출금할 돈 입력 ");
                int money = sc.nextInt();
                if (Integer.parseInt(members[i][2])<money){
                    System.out.println("출금할 돈 부족");
                }else{
                    if(members[i][2]==null){
                        members[i][2]= String.valueOf(0);
                    }
                    members[i][2]= Integer.toString(Integer.parseInt(members[i][2])-money);
                    System.out.println("출금완료");
                    insertHistory(i,members,"[출금]",Integer.toString(money));
                }
                return;
            }
        }
        System.out.println("계좌번호 틀림");
    }

    private static void checkCurrentAmount(String[][] members){
        Scanner sc = new Scanner(System.in);
        //계좌번호로 계좌 찾기
        System.out.println("계좌번호 입력");
        String account = sc.nextLine();
        for (int i = 0; i < accountNum; i++) {
            if(account.equals(members[i][0])) {
                System.out.print("계좌번호 : "+members[i][0]+" ");
                System.out.println("이름 : "+members[i][1]);
                System.out.println("잔액 : "+members[i][2]);
                return;
            }
        }
        System.out.println("계좌번호 틀림");
    }
    private  static  void insertHistory(int tracking, String[][] members ,String depositWithdrawal,String account){
        members[tracking][3] = members[tracking][3] + depositWithdrawal+" "+account+ " " + dateFormat()+" ";

    }
    private  static String dateFormat(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }


    private static void historyInquiry(String[][] members) {
        Scanner sc = new Scanner(System.in);
        //계좌번호로 계좌 찾기
        System.out.println("계좌번호 입력");
        String account = sc.nextLine();
        for (int i = 0; i < accountNum; i++) {
            if(account.equals(members[i][0])) {
                String[] historyLength = members[i][3].split(" ");
                // 삭제할 요소 수 (앞부분 삭제)
                int numElementsToRemove =historyLength.length-20; // 삭제할 요소의 수 (앞에서부터)
                // 배열의 크기가 삭제할 요소 수보다 클 때만 처리
                if (historyLength.length > 20) {
                    // 새 배열 생성 그래야 20개를 담는다
                    String[] trimmedArray = new String[20];
                    System.arraycopy(historyLength, numElementsToRemove, trimmedArray, 0, 20);
                    //배열에 넣기 5개만 이래야 최신순으로 저장
                    for (int j = trimmedArray.length-1; j >=0; j--) {
                        members[i][3] += trimmedArray[j]+" ";
                    }

                    printHistory(trimmedArray);
                    return;
                }
                printHistory(historyLength);
                return;


            }
        }
        System.out.println("계좌번호 틀림");
    }
    private static void printHistory(String[] strs) {
        int loopCount=0;
        for(String str : strs){
            System.out.print(str);
            loopCount++;
            if(loopCount==4){
                loopCount=0;
                System.out.println();
            }else if(loopCount==3){
                System.out.print(" ");
            }else{
                System.out.print(" : ");
            }
        }
    }
    public static void main(String[] args) {
        // 계좌
        // 계좌번호 이름 잔액 내역

        String[][] members= new String[accountNum][4];
        makeAccount(members);
        while(true){
            int select  = printSelect();

            switch (select){
                case 1:
                    depositMoney(members);
                    break;
                case 2:
                    withdrawMoney(members);
                    break;
                case 3:
                    checkCurrentAmount(members);
                    break;
                case 4:
                    historyInquiry(members);
                    break;
                case 5:
                    System.out.println("시스템 종료");
                    return;
                default:
                    System.out.println("잘못누르셨습니다.");
                    break;

            }


        }
    }



}
