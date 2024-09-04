package himedia.practice.member;

import java.util.*;

public class Managementlmpl implements Member{
    private Rateplan pricePlan;

        // 요금제
    private int ratePlan;
    // 멤버관리
    Map<String, String> member ;
    // 회원수
    private int memberCount=0;

    public Managementlmpl() {
        this.ratePlan = 10;
        this.member = new HashMap<>();
    }


    @Override
    public void ratePlanPrint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명 [4]Free pass : 무제한");
        int planNum=sc.nextInt();
        switch (planNum){
            case 1:
                Rateplan.LITE.getCount();
                break;
            case 2:
                Rateplan.BASIC.getCount();
                break;
            case 3:
                Rateplan.PREMIUM.getCount();
                break;
            case 4:
                checkPlan(Rateplan.FREEPASS.getCount());
                break;
            default:
                System.out.println("잘못 누름");
                ratePlanPrint();
        }
    }
    public boolean checkPlan(int plan){
        if(plan>=ratePlan){
            System.out.println("작다");

        }
        return false;
    }
    @Override
    public int menuPrint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 회원수 : "+ memberCount+"/"+ratePlan);
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)\n[4]전체조회"+
                " [5]회원정보 수정 [6]회원삭제\n[7]요금제 변경 [8]초기화 [9]프로그램 종료");
        return sc.nextInt();
    }

    @Override
    public void userAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 메일 입력");
        String mail=sc.nextLine();
        System.out.println("회원 이름 안내");
        String name=sc.nextLine();
        System.out.println("회원 번호");
        String phone=sc.nextLine();

        if(member.size()==ratePlan&&ratePlan!=-1){
            System.out.println("요금제를 변경하시오.");
            return;
        }
        member.put(mail, Arrays.toString(new String[]{name, phone}));
        memberCount=memberCount+1;
    }

    @Override
    public void userFindMail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 메일 입력");
        String mail=sc.nextLine();
        if(member.containsKey(mail)) {
            for (String user : member.keySet()) {
                System.out.println("Name: " + user + ", Mail: " + member.get(user));
                return;
            }
        }else {
            System.out.println("메일 없음");
            return;
        }
    }

    @Override
    public void userFindName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 이름 입력");
        String name=sc.nextLine();
        if(member.containsValue(name)){
            for (String user : member.keySet()) {
                System.out.println("Name: " + user + ", Mail: " + member.get(user));
            }
            return;
        }else {
            System.out.println("메일 없음");
            return;
        }
    }

    @Override
    public void userFindAll() {
        for (String user : member.keySet()) {
            System.out.println("Name: " + user + ", Mail: " + member.get(user));
        }
    }

    @Override
    public void replaceUserInform() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 메일 입력");
        String mail=sc.nextLine();
        if(member.containsKey(mail)){
            System.out.println("회원 입력");
            String name=sc.nextLine();
            member.replace(mail, name);
        }else {
            System.out.println("메일 없음");
            return;
        }
    }

    @Override
    public void userDel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 메일 입력");
        String mail=sc.nextLine();
        if(member.containsKey(mail)){
            member.remove(mail);
            System.out.println("삭제 완료");
        }else {
            System.out.println("메일 없음");
            return;
        }
    }

    @Override
    public void changeRatePlan() {
        ratePlanPrint();
    }

    @Override
    public void reset() {
        member.clear();
        memberCount=0;
    }


}
