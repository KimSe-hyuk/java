package pratice;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Join_Mem mem = new Join_the_membership();
        while (true){
            int num = mem.printMenu();
            switch (num){
                case 1:
                    mem.printJoinMem();
                    break;
                case 2:
                    mem.printlogInMem();
                    break;
                case 3:
                    System.out.println("종료");
                    break;
            }
        }
    }
}
