package com.himeda.practice;

public class N_Start {
    /*

    Vending.class(I) -> 자판기 기능에 해당하는 모든 메서드 명세
Machine.class-> 인터페이스에 명세된 메서드 구현
		->필드는 모두 private
		-> 필드값제어는 Getter와 Setter로만
		-> setter에 유효성 체크 추가할 것.
start.class->오직 while문과 switch-case문만 가진다.
		->다형을 적용하여 생성한다.
static은 오직 main메서드만 사용
단, 상수 목적으로는 사용 pk
     */
    static final int COKE = 500, CIDER = 700, FANTA = 300, WATER = 200;

    public static void main(String[] args) {
                N_Vending machine = new N_Machine();

                while (true) {
                    machine.printMenu();
                    int myChoice = machine.getChoice();
                    switch (myChoice) {
                        case 1:
                            if (machine.setTotalMoney(machine.calcMoney(COKE)) ) {
                                System.out.println("콜라가 나왔습니다.");
                            } else {
                                machine.printException();
                            }
                            break;
                        case 2:
                            if (machine.setTotalMoney(machine.calcMoney(CIDER)) ) {
                                System.out.println("사이다가 나왔습니다.");
                            } else {
                                machine.printException();
                            }
                            break;
                        case 3:
                            if (machine.setTotalMoney(machine.calcMoney(FANTA)) ) {
                                System.out.println("환타가 나왔습니다.");
                            } else {
                                machine.printException();
                            }
                            break;
                        case 4:
                            machine.calcMoney(WATER);
                            if (machine.setTotalMoney(machine.calcMoney(WATER)) ) {
                                System.out.println("물이 나왔습니다.");
                            } else {
                                machine.printException();
                            }
                            break;
                        case 5:
                            // getMoney
                            machine.getMoney();
                            break;
                        case 6:
                            System.out.printf("잔돈 : %d원이 반환되었습니다.", machine.getTotalMoney());
                            return;
                        default:
                            System.out.println("잘 못 누르셨습니다.");
                    }
                }

            }
        }


