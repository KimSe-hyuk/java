package himedia.practice.member;

/*
-> Memeber.java(I) 인터페이스
-> Managementlmpl.java 구현체 // 필드 -> private
-> Start.java  시작

// 반드시 Collections중 하나를 적용할 것
[1]Lite : 10명 [2]Basic : 20명 [3]Primium : 30명 [4]Freepass : 무제한

요금제 관리 -> enum

[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)
[4]전체조회 [5]회원정보 수정 [6]회원삭제
[7]요금제 변경 [8]초기화 [9]프로그램 종료

10명...-> 꽉 차면 요금제를 변경하시오.

ratePlan
요금제 프린트() ratePlanPrint()
메뉴프린트 ()   menuPrint()

회원추가        userAdd()
회원조회(이메일) userFindMail()
회원 조회(이름) userFindName()
전체 조회       userFindAll()
회원정보 수정     replaceUserInform()
회원 삭제       userDel()
요금제 변경      changeRatePlan
초기화         reset()

 */
public class Start {
    public static void main(String[] args) {
        Member management = new Managementlmpl();
        management.ratePlanPrint();
        while(true){
            int selectNum = management.menuPrint();
            switch (selectNum){
                case 1:
                    management.userAdd();
                    break;
                case 2:
                    management.userFindMail();
                    break;
                case 3:
                    management.userFindName();
                    break;
                case 4:
                    management.userFindAll();
                    break;
                case 5:
                    management.replaceUserInform();
                    break;
                case 6:
                    management.userDel();
                    break;
                case 7:
                    management.changeRatePlan();
                    break;
                case 8:
                    management.reset();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못 입력");
                    break;
            }
        }
    }
}
