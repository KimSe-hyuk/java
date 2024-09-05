package himedia.practice.account2;

import java.util.Scanner;

/*
map(날짜,list)
1. 가계부 내역 추가
공책 :1000원
연필 : 300원
합계 : 1300원
2. 내역조회
-> 과거 날짜 제목들 리스트가 나온다
2024-09-4
2024-09-02
-> 제목을 입력하면(20204-09-04) 해당 날짜의 내역들이 나온다
3. 전체 삭ㄱ제
- 제목을 입력한 날짜와 내역을 삭제시킨다.
4. 내역 삭제 내역들 중 특정 항목을 삭제시킬수 있다.
5. 프로그램종료

menuPrint
AccountBookPlus
AccountBookList
AccountBookAllDel
AccountBookdel

 */
public class Start {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountBook accountBook = new AccountBooklmpl();
        while (true){
            switch ( accountBook.menuPrint()){
                case 1:
                    accountBook.AccountBookPlus();
                    break;
                case 2:
                    accountBook.AccountBookList();
                    break;
                case 3:
                    accountBook.AccountBookAllDel();
                    break;
                case 4:
                    accountBook.AccountBookdel();
                    break;
                case 6:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못 누름");
                    break;
            }
        }
    }
}
