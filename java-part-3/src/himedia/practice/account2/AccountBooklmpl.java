package himedia.practice.account2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountBooklmpl implements AccountBook {
    Map<String,List<String[]>> accounts;
    public AccountBooklmpl() {
        this.accounts = new HashMap<>();
    }
    private  static String dateFormat(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDateTime.format(formatter);
    }

    @Override
    public int menuPrint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 가계부 내역 추가 2. 내역조회 3. 전체 삭제 4. 내역 삭제");
        return sc.nextInt();
    }

    @Override
    public void AccountBookPlus() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        List<String[]> accountList = new ArrayList<>();
        while(true) {
            System.out.println("가계부에 추가할 물품과 가격을 입력하시오 ");
            System.out.println("stop 입력할시 종료");
            System.out.print("물품 : ");
            String name = sc.nextLine();

            if (!name.equals("stop")) {
                System.out.print("가격 : ");

                int price = sc.nextInt();
                sc.nextLine();
                sum += price;
                accountList.add(new String[]{name,Integer.toString(price)});
            } else {
                accountList.add(new String[]{"합계", String.valueOf(sum)});
                accounts.put(dateFormat(), accountList);
                System.out.println("종료");
                break;
            }
        }
    }

    @Override
    public void AccountBookList() {
        Scanner sc = new Scanner(System.in);
        if(accounts.isEmpty()){
            return;
        }

        for (String name : accounts.keySet()) {
            System.out.println(name);
        }

        System.out.println("내역을 볼 날짜를 입력하시오");
        String date = sc.nextLine();

        for(String name : accounts.keySet()){
            if(name.equals(date)){
                System.out.println(name);
                for (int i = 0; i < accounts.get(name).size(); i++) {
                    System.out.println(accounts.get(name).get(i)[0]+" : "+accounts.get(name).get(i)[1]+"원");;

                }
                return;
            }
            System.out.println("날짜가 없습니다.");
        }




    }

    @Override
    public void AccountBookAllDel() {
        if(accounts.isEmpty()){
            return;
        }
        accounts.clear();
        System.out.println("전체 삭제 완료");
    }

    @Override
    public void AccountBookdel() {
        List<String[]> accountList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 내역을 입력하시오");
        String findName = sc.nextLine();
        if(accounts.isEmpty()){
            System.out.println("배열 없음");
            return;
        }
        for(String name : accounts.keySet()) {
            for (int i = 0; i < accounts.get(name).size(); i++) {
                if (findName.equals(accounts.get(name).get(i)[0])) {
                    int sum = Integer.parseInt(accounts.get(name).getLast()[1]);
                    int minus = Integer.parseInt(accounts.get(name).get(i)[1]);
                    accounts.get(name).remove(i);
                    accounts.get(name).removeLast();
                    accountList = new ArrayList<>(accounts.get(name));
                    accountList.add(new String[]{"합계", Integer.toString(sum - minus)});
                    accounts.put(name, accountList);
                    System.out.println("삭제 완료");
                    return;
                }
            }

        }
        System.out.println("날짜가 없습니다.");

    }
}
