package himedia.java;

import java.util.*;

//구현체
public class A_reviewlmpl implements Review {
    private final Map<String, String> mapContents;
    private final Map<String, Integer> mapLike;

    public A_reviewlmpl(Map<String, String> stringIntegerTreeMap, Map<String, Integer> stringIntegerTreeMap2) {

        this.mapContents = stringIntegerTreeMap;
        this.mapLike = stringIntegerTreeMap2;


    }
    public boolean trim(String id){
        if(id.trim().isEmpty()){
            System.out.println("ID입력이 비어있습니다.");
            return true;
        }return false;
    }
    @Override
    public int printMenu() {
        Scanner sc =new Scanner(System.in);
        System.out.println("[1] 댓글 추가 [2] 좋아요 추가 [3] 전체 보기 [4] 내용삭제 [5] 좋아요 순으로 정렬 [6] 종료");
        return sc.nextInt();
    }

    @Override
    public void commentAdd() {
        Scanner sc =new Scanner(System.in);
        System.out.println("사용자 ID 입력");
        String id = sc.nextLine();
        if(trim(id)){
            return;
        }
        System.out.println("내용 입력");
        String content = sc.nextLine();
        if(trim(content)){
            return;
        }
        if(mapContents.containsKey(id)) {
            System.out.println("이미 있는 사용자 ID 입니다.");
            return;
        }
        mapContents.put(id, content);
    }

    @Override
    public void likeAdd() {
        Scanner sc =new Scanner(System.in);
        for(String key : mapContents.keySet()) {
            System.out.println("사용자ID : " + key + "내용 : "+ mapContents.get(key));
        }
        System.out.println("사용자ID를 입력");
        String id = sc.nextLine();
        if(trim(id)){
            return;
        }
        if(mapContents.containsKey(id)) {
            mapLike.put(id, mapLike.get(id) == null ? 1 : mapLike.get(id) + 1);
        }else{
            System.out.println("ID를 찾지 못함");
            return;
        }
    }

    @Override
    public void likePrint() {
        for(String key : mapContents.keySet()) {
                System.out.println("사용자 ID : "+ key + " 좋아요 갯수 : " + (mapLike.get(key)==null?"0":mapLike.get(key))+" 내용 : "+ mapContents.get(key));
        }
    }

    @Override
    public void commentDel() {
        Scanner sc =new Scanner(System.in);
        System.out.println("삭제할 ID를 작성하시오");
        String id = sc.nextLine();
        if(trim(id)){
            return;
        }

        if(mapContents.containsKey(id)) {
            mapContents.remove(id);
            if(mapLike.containsKey(id)) {
                mapLike.remove(id);
            }
            System.out.println("삭제 완료");
            return;
        }
        System.out.println("ID를 찾지 못함");
    }

    @Override
    public void likeSortPrint() {

        List<String> keySet = new ArrayList<>(mapLike.keySet());
        keySet.sort((o1, o2) -> mapLike.get(o2).compareTo(mapLike.get(o1)));//내림차순
        // keySet.sort((o1, o2) -> mapLike.get(o1).compareTo(mapLike.get(o2))); //오름차순
        for(String key : keySet) {
            System.out.println("사용자 ID : " + key + " 좋아요 갯수 : "+ mapLike.get(key) + " 내용 : " + mapContents.get(key));
        }




/*
        List<Map.Entry<String, Integer>> keySet = new LinkedList<>(mapLike.entrySet());
        keySet.sort(Map.Entry.comparingByValue());


        for(Map.Entry<String, Integer> entry  : keySet) {
            System.out.println("사용자 ID : " + entry.getKey()  + " 좋아요 갯수 : "+ entry.getValue() + " 내용 : " + mapContents.get(entry.getKey() ));
        }

*/
        for(String key : mapContents.keySet()) {
            if (mapLike.get(key) == null){
                System.out.println("사용자 ID : " + key + " 좋아요 갯수 : 0" + " 내용 : " + mapContents.get(key));
            }
        }
    }
}
