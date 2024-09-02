package himedia.practice;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

public class A_collection_list {

    public  static  void exam1(){
        List<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        System.out.println(list);

        list.remove("orange");
        list.remove(1);
        System.out.println(list);
        list.clear();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        if(list.contains("orange")){
            System.out.println("elements contain: orange");
        };
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(String s : list){
            System.out.println(s);
        }
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }
    public  static  void exam2(){
        Stack<String> stack = new Stack<>();

        stack.push("apple");
        stack.push("banana");
        stack.push("orange");
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.clear();
        System.out.println(stack.empty());

        while(!stack.isEmpty()){
            String element = stack.pop();
            System.out.println("Popped elements : " +element);
        }
        System.out.println("Stack elements : " + stack);
    }
    public static void main(String[] args) {
        exam1();
    }
}
