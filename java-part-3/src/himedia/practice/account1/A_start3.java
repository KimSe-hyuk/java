package himedia.java.account1;

public class A_start3 {
    public static void main(String[] args) {
        A_account accountSelect = new A_accountlmpl();
        accountSelect.makeAccount();
        while (true){
            int selectNum = accountSelect.showMenu();
            switch(selectNum){
                case 1:
                    accountSelect.depositAccount();
                    break;
                case 2:
                    accountSelect.withdrawAccount();
                    break;
                case 3:
                    accountSelect.showAccount();
                    break;
                case 4:
                    accountSelect.historyInquiry();
                    break;
                case 5:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못 누름");
                    break;
            }
        }
    }
}
