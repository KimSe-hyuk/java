package himedia.practice.account1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A_accountlmpl implements A_account {
    private int balanse;
    static ArrayList<String> history;
    private String name="";
    private String accountNum="";
    public A_accountlmpl() {
        this.history = new ArrayList<>();
        this.balanse=0;
    }


    @Override
    public void makeAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        StringBuilder num = new StringBuilder();
        int i=1;
        while(i<=6){
            String a=Integer.toString((int) (Math.random() * 10));
            if(num.indexOf(String.valueOf(num))!=-1){
                num.append(a);
                i++;
            };
        }

        accountNum = String.valueOf(num);
        name=sc.nextLine();

    }

    @Override
    public void depositAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금하시오");
        int deposit=sc.nextInt();
        balanse+=deposit;
        insertHistory("[입금]",deposit, balanse);
    }

    @Override
    public void withdrawAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("출금하시오");
        int withdrawal=sc.nextInt();
        if(balanse<withdrawal){
            System.out.println("잔액 부족");
            return;
        }else{
            balanse-=withdrawal;
            insertHistory("[출금]",withdrawal, balanse);
            }

    }

    @Override
    public void showAccount() {
        System.out.println("현재 잔액 : "+balanse);
    }

    @Override
    public void historyInquiry() {
        history.sort(Comparator.reverseOrder());
        //Collections.reverse(history);
//        Comparator.reverseOrder(): 내림차순 정렬을 수행합니다.
//                Collections.reverse(history): 현재 순서를 반전시킵니다.
        for (String a : history) {
            System.out.println(a);
        }
    }

    @Override
    public int showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름 : "+name+" 계좌번호 : "+accountNum +" 잔액 : "+balanse);
        System.out.println("[1]입금 [2]출금 [3]현재 금액 조회 [4]내역조회 [5]프로그램 종료");
        return sc.nextInt();
    }

    private   void insertHistory( String a,int amount,int balanse){
        history.add(a + " 액수 : "+amount +" "+dateFormat()+" 잔액 : "+balanse );

    }

    private  static String dateFormat(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
