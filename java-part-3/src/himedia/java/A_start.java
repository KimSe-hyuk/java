package himedia.java;
// 시작점

import java.util.TreeMap;
import java.util.HashMap;
/*
[1].댓글추가
-> 사용자ID, 내용을입력받는다. -> 사용자ID, 내용이 비어 있으면 등록시키지않는다. ~trim()(공백문자열 제거)
--> 이미 사용자ID가 있으면 그냥 덮어 씌운다.
+ 좋아요 갯수도 0개로 초기화
[2]좋아요
리스트가 출력
사용자 ID : 내용1 ~~
사요자 ID : 내용2 ~~
사용자ID를 입력 -> 좋아요 +1
[3] 전체보기
사용자 ID 별 좋아요 갯수를 출력
사용자 ID 3 : 내용
[4] 내용 삭제
[5] 종료

해쉬맵 2개로
userComment(userID, contents);
userLike(userID, like);

메뉴 출력 printMenu()
메서드 댓글추가 commentAdd();
좋아요 추가 likeAdd()
좋아요 출력 likePrint()
내용 삭제 contentsDel()
 */
public class A_start {
    public static void main(String[] args) {
        Review review = new A_reviewlmpl(new TreeMap<String,String>(),new TreeMap<String,Integer>());
        while (true){
            int selectNum = review.printMenu();
            switch (selectNum){
                case 1:
                    review.commentAdd();
                    break;
                case 2:
                    review.likeAdd();
                    break;
                case 3:
                    review.likePrint();
                    break;
                case 4:
                    review.commentDel();
                    break;
                case 5:
                    review.likeSortPrint();
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
