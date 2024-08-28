package com.himedia.java;

import java.util.Scanner;

public class K2_member_management {
    private static int USERCOUNT= 0;
    private static String[][] makeRatePlan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]요금제 : Lite 10명, [2]Basic 20명, [3]Premium 30명");
        return new String[sc.nextInt()*10][3];
    }
    private static int printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.회원추가 2.회원조회 3.회원정보 수정 4.회원삭제, 5.종료");
        return sc.nextInt();
    }
    public static void main() {
        String[][] ratePlane=makeRatePlan();
        while (true){
            int menuSelect = printMenu();
            switch (menuSelect){
                case 1:
                    memberAdd(ratePlane);
                    break;
                case 2:
                    memberChck(ratePlane);
                    break;
                case 3:
                    memberEditInformation(ratePlane);
                    break;
                case 4:
                    deleteMember(ratePlane);
                    break;
                case 5:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못누름");
                    break;
            }
        }

    }

    private static void deleteMember(String[][] ratePlane) {
        Scanner sc = new Scanner(System.in);
        System.out.println("멤버 삭제할 이메일 입력");
        String findName = sc.nextLine();
        for (int i = 0; i < ratePlane.length; i++) {
            if (findName.equals(ratePlane[i][1])){
                for (int j = i; j < USERCOUNT-1; j++) {
                    ratePlane[j][0] = ratePlane[j+1][0];
                    ratePlane[j][1] = ratePlane[j+1][1];
                    ratePlane[j][2] = ratePlane[j+1][2];
                }
                ratePlane[USERCOUNT-1][0] = null;
                ratePlane[USERCOUNT-1][1] = null;
                ratePlane[USERCOUNT-1][2] = null;
                USERCOUNT--;
                System.out.println("삭제완료");
                return;
            }
        }
        System.out.println("이메일 틀림");

    }

    private static void memberEditInformation(String[][] ratePlane) {
        Scanner sc = new Scanner(System.in);
        System.out.println("멤버 수정할 이메일 입력");
        String findName = sc.nextLine();
        int idx=-1;
        for (int i = 0; i < ratePlane.length; i++) {
            if (findName.equals(ratePlane[i][1])) {
                idx = i;
                break;
            }
        }
        if(idx==-1) {
            System.out.println("이메일 확인 불가");
            return;
        }

            System.out.println("변경할 이름입력");
            String name=sc.nextLine();
            System.out.println("변경할 이메일입력");
            String email = sc.nextLine();
            System.out.println("변경할 번호입력");
            String phone = sc.nextLine();
            if(!emailDuplicationCheck(ratePlane,email)){
                System.out.println("중복이메일 확인");
                return;
            };

            ratePlane[idx][0]=name;
            ratePlane[idx][1]=email;
            ratePlane[idx][2]=phone;
            System.out.println("변경 완료");

    }

    private static void memberChck(String[][] ratePlane) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]이름조회 [2]이메일조회 [3]전체조회");
        int selectNum = sc.nextInt();
        switch (selectNum){
            case 1:
                checkName(ratePlane,"이름",selectNum);
                break;
            case 2:
                checkName(ratePlane,"이메일",selectNum);
                break;
            case 3:
                checkAll(ratePlane);
                break;
        }
    }
    private static void checkName(String[][] ratePlane ,String sec,int selectNum) {
        if(USERCOUNT<0){
            System.out.println("정보 없음");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(sec + " 입력");
        String findName = sc.nextLine();
        int idx=0;
        for (String[] s : ratePlane){
            if (findName.equals(s[selectNum-1])){
                System.out.println("이름 : "+s[0]+" 이메일 : "+s[1]+" 전화번호"+ s[2]);
                idx++;
                if(selectNum==2){return;}
            }
        }
        if(idx==0){
            System.out.println("찾지못함");
        }
    }

    private static void checkAll(String[][] ratePlane) {
        if(USERCOUNT<0){
            System.out.println("정보 없음");
            return;
        }
        for (String[] s : ratePlane){
            if(s[1]!=null)System.out.println("이름 : "+s[0]+" 이메일 : "+s[1]+" 전화번호"+ s[2]);
        }
    }

    private static void memberAdd(String[][] ratePlane) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름입력");
        String name=sc.nextLine();
        System.out.println("이메일입력");
        String email = sc.nextLine();
        if(!emailDuplicationCheck(ratePlane,email)){
            System.out.println("중복이메일 확인");
            return;
        };
        System.out.println("번호입력");
        String phone = sc.nextLine();
        ratePlane[USERCOUNT][0]=name;
        ratePlane[USERCOUNT][1]=email;
        ratePlane[USERCOUNT][2]=phone;
        USERCOUNT++;

    }
    private static boolean emailDuplicationCheck(String[][] ratePlane,String email) {
        if(USERCOUNT>0){
            for (String[] s : ratePlane) {
                if (email.equals(s[1])) return false;
            }
        }
       return true;
    }

}

