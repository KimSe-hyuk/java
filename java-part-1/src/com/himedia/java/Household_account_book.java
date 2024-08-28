package com.himedia.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Household_account_book {
    private static final String[][] householdAccountBook=new String[12][10];
    public static void main(String[] args) {
        // 1,12개에 달 선택
        // 달별로 받아와서 월구매목록 리스트 실행
        // purchaseList(구매목록 에서 selectMonth실행으로  purchaseList를다시실행
        // printMenu() 구매목록 출력+int 값 돌려줌 10개 물건 리스트 출력
        // goodsList 물건 메뉴 10개 출력
        // articleAdd() articleReplace ()  articleContentsDeleate() articleContentsAllDeleate()
        // 보내는 배열 [달][10개 이름 가격 일자 Str
        // ing으로 추가]
            purchaseList(selectMonth());
        }


    private static int printMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("[1]물품 추가 [2]물품 내용 수정 [3]물품 내용 삭제 [4]물품 내용 전체 삭제 [5]월선택 [6]물건 리스트 출력");
        return sc.nextInt();
    }
    private static void purchaseList(int slcMonth){
        while(true){
            printGoods(slcMonth);
            //메뉴
            switch (printMenu()){
                case 1:
                    goodsAdd(slcMonth);
                    break;
                case 2:
                    articleReplace (slcMonth);
                    break;
                case 3:
                    articleContentsDeleate(slcMonth);
                    break;
                case 4:
                    articleContentsAllDeleate(slcMonth);
                    break;
                case 5:
                    //월을 다시실행
                    purchaseList(selectMonth());
                    break;
                case 6:
                    printGoods(slcMonth);
                    break;
                default:
                    System.out.println("잘못누름");
                    break;
            }

        }

    }

    private static void articleContentsAllDeleate(int slcMonth) {
        Arrays.fill(householdAccountBook[slcMonth], null);
    }

    private static void articleContentsDeleate(int slcMonth) {
        int ARTICLE_COUNT=articleCount(slcMonth);
        int idx =-1;
        Scanner sc=new Scanner(System.in);
        System.out.println("삭제할 물품 이름 : ");
        String artcleName=sc.nextLine();

        for (int i = 0; i < ARTICLE_COUNT; i++) {
            String[] fruits = householdAccountBook[slcMonth][i].split(" ");
            if(artcleName.equals(fruits[0])) {
                idx=i;
            }
        }
        if(idx==-1){
            System.out.println("삭제할 물품 이름 틀림");
            return;
        }else{
            householdAccountBook[slcMonth][idx]=householdAccountBook[slcMonth][ARTICLE_COUNT-1];
            householdAccountBook[slcMonth][ARTICLE_COUNT-1]=null;
            System.out.println("삭제완료");
        }
    }

    private static void articleReplace(int slcMonth) {
        int ARTICLE_COUNT=articleCount(slcMonth);
        int idx =-1;
        Scanner sc=new Scanner(System.in);
        System.out.println("수정할 물품 이름 : ");
        String artcleName=sc.nextLine();
        for (int i = 0; i < ARTICLE_COUNT; i++) {
                String[] fruits = householdAccountBook[slcMonth][i].split(" ");
                if(artcleName.equals(fruits[0])) {
                   idx=i;
                }
        }
        if(idx==-1){
            System.out.println("수정할 물품 이름 틀림");
            return;
        }
        System.out.println("===============");
        System.out.println("변경 물품 이름 : ");
        String newName=sc.nextLine();
        System.out.println("변경 물품 가격 : ");
        String newPrice=sc.nextLine();

        for (int i = 0; i < ARTICLE_COUNT; i++) {
            String[] fruits = householdAccountBook[slcMonth][i].split(" ");
            if(newName.equals(fruits[0])) {
                idx=i;
            }
        }
        if(idx==-1){
            System.out.println("변경할 물품 이름 틀림");
            return;
        }
        else{
            householdAccountBook[slcMonth][idx]=newName+" "+newPrice+" "+getNowDateTime()+" ";
            System.out.println("수정완료");
        }
    }
    private static int articleCount(int slcMonth) {
        int ARTICLE_COUNT=0;
        for (String a :householdAccountBook[slcMonth]){
            if(a!=null)ARTICLE_COUNT++;
        }
        return ARTICLE_COUNT;
    }
    private static void goodsAdd(int slcMonth) {
        int ARTICLE_COUNT=articleCount(slcMonth);
        Scanner sc=new Scanner(System.in);
        System.out.println("물품 이름");
        String articleName=sc.nextLine();
        System.out.println("물품 가격");
        String articlePrice=sc.nextLine();
        if(duplicationArticleName(articleName,slcMonth)){
            System.out.println("중복된 이름");
            return;
        }

        if(ARTICLE_COUNT>=10){
            System.arraycopy(householdAccountBook[slcMonth], 1, householdAccountBook[slcMonth], 0, 9);
            ARTICLE_COUNT--;
        }
        householdAccountBook[slcMonth][ARTICLE_COUNT]=articleName+" "+articlePrice+" "+getNowDateTime()+" ";
    }
    private static boolean duplicationArticleName(String articleName, int slcMonth){

        if(householdAccountBook[slcMonth][0]!=null){
            for (String art: householdAccountBook[slcMonth]){
                if(art==null)continue;
                String[] fruits = art.split(" ");
                if(articleName.equals(fruits[0]))return true;
            }
        }
        return false;
    }
    private  static String getNowDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    private static void printGoods(int slcMonth) {
        for (String goods : householdAccountBook[slcMonth]) {
            if (goods != null) {
                System.out.println(goods);
            }
        }
    }

    private static int selectMonth () {
        Scanner sc=new Scanner(System.in);
        System.out.println("1~12월 선택하시오");
        return sc.nextInt();
    }
}
