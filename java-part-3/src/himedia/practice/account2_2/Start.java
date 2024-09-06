package himedia.practice.account2_2;

import java.util.Scanner;

/*
1. 가계부 내역 추가
->  오늘 날짜의 파일(.txt)이 없으면 자동으로 생성한다.
-> 있으면 기존 내역에 해당 내용을 추가한다.
->  추가 형식 :
공책 :1000원
연필 : 300원
합계 : 1300원
2. 내역조회
-> 과거 날짜 제목들 리스트가 나온다
2024-09-4
2024-09-02
-> 제목을 입력하면(20204-09-04) 해당 날짜의 내역들이 나온다
3. 전체 삭ㄱ제
- 제목을 입력한 파일을 삭제시킨다.
5. 프로그램종료
 */
public class Start {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountBook accountBook = new AccountBooklmpl();
        ((AccountBooklmpl) accountBook).makeForder();
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
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못 누름");
                    break;
            }
        }
    }
}