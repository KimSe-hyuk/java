package com.himedia.java;

import java.util.Scanner;

public class K_member_management {

    //총 인원
    static int totalCnt =0;
    //현재 인원
    static int totalMemberCnt =0;

    //요금제
    public static int printPricePlan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[요금제를 선택하세요.]");
        System.out.println("[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명");

        return sc.nextInt();
    }

    public static int printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[수행할 업무를 선택하세요 - 현재회원수] " + totalMemberCnt + " / " + totalCnt);
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]전체조회 [5]회원정보 수정 [6]회원 삭제");
        System.out.println("[7]프로그램 종료");

        return sc.nextInt();
    }

    public  static void addMember(String[][] members){
        // 인원수 예외처리를 해주세요.
        // 인원이 초과됐으면,"회원이 꽉찼습니다."출력하고
        // addMember함수를 종료시켜주세요
        if(totalMemberCnt>=totalCnt){
            System.out.println("회원이 꽉찼습니다.");
            return;
        }
        // 사용자로부터 이름, 이메일, 연락처
        // members에 넣어주세요.
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력하세요.");
        String email=sc.nextLine();
        System.out.println("연락처를 입력하세요");
        String phone = sc.nextLine();

        // -> 예외처리2
        // 이메일 체크 필요


        if(checkEmail(members,email)){
            System.out.println("이미 존재하는 회원입니다.");
            return;
        }

        members[totalMemberCnt][0]=name;
        members[totalMemberCnt][1]=email;
        members[totalMemberCnt][2]=phone;

        totalMemberCnt++;

    }
    public static boolean checkEmail(String[][] members, String email){
        //회원 조재시 true 존재하지 않으면 false
        for ( String[] mem : members ){
            if (email.equals(mem[1])) {
                return true;
            }
        }
        return false;
    }

    public static void selectEmail(String[][] members){
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이메일을 입력하세요.");
        String email = sc.nextLine();
        for (int i = 0; i < members.length; i++) {
            if (email.equals(members[i][1])){
                System.out.println("[이름]"+members[i][0]+", [이메일] "+members[i][1]+", [연락처] "+members[i][2]);
                return;
            }
        }
        System.out.println("찾으시는 정보가 없습니다.");
        /*
        for ( String[] mem : members ){
            if (email.equals(mem[1])) {
                System.out.println("[이름] " + mem[0] + ", [이메일] " + mem[1] + ", [연락처] " + mem[2]);
            }
        }*/
    }
    public static void selectName(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이름을 입력하세요.");
        String name = sc.nextLine();
        boolean find = false;
        for (int i = 0; i < members.length; i++) {
            if (name.equals(members[i][0])) {
                System.out.println("[이름]" + members[i][0] + ", [이메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                find = true;
            }
        }
        if(!find)System.out.println("찾으시는 정보가 없습니다.");

    }
    private static void selectAll(String[][] members) {
        for (int i = 0; i < totalMemberCnt; i++) {
            System.out.println("[이름]" + members[i][0] + ", [이메일] " + members[i][1] + ", [연락처] " + members[i][2]);
        }
        /*
        for (String[] mem : members) {
            if(mem[0]!=null)System.out.println("[이름] " + mem[0] + ", [이메일] " + mem[1] + ", [연락처] " + mem[2]);
        }
        */
    }
    private static void deleteMember(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[삭제] 이메일을 입력하세요.");
        String email = sc.nextLine();
        for (int i = 0; i < totalMemberCnt; i++) {
            if (email.equals(members[i][1])) {
                for(int j=0;j<3;j++){
                    members[i][j]=members[totalMemberCnt-1][j];
                    members[totalMemberCnt-1][j]=null;
                }

                totalMemberCnt--;
                System.out.println("삭제 완료");
                return;
            }
        }
        System.out.println("이메일이 없습니다.");
    }
    public static void main(String[] args) {
        // 사용자로부터 요금제 선택을 받아서
        // 해당 크기에 맞는 2차원 배열을 생성해주세요.
        // 단, 열은 3열로 고정한다.
        // 배열명 : members
        int pricePlanNum = printPricePlan();
        totalCnt = pricePlanNum*10;
        String[][] members= new String[pricePlanNum*10][3];

        while (true){
            int menuNum = printMenu();
            switch (menuNum){
                case 1:
                    addMember(members);
                    break;
                case 2:
                    selectEmail(members);
                    break;
                case 3:
                    selectName(members);
                    break;
                case 4:
                    selectAll(members);
                    break;
                case 5:
                    break;
                case 6:
                    deleteMember(members);
                    break;
                case 7:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("범위 밖");
            }

        }
    }

}
