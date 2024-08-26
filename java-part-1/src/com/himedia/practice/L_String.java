package com.himedia.practice;

public class L_String {

    //charAt(int index)
    public static  void exam1(){
        String str = "Hello";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
    // 2. substring(int beginInex, int endIndex)
    public static void exam2(){
        String str = "Hello";
        str = str.substring(0,3);
        System.out.println(str);
    }
    // 3. split(String regex)
    public static void exam3(){
        String str = "one two three";
        String[] strs = str.split(" ");
        for(String s : strs){
            System.out.println(s);
        }
    }
    // 4. toCharArray()
    public static void exam4(){
        String str = "Hello";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }
    }
    // 5. equals(String anotherString)
    public static void exam5(){
        String str = "Hello";
        String str2 = "Hello";
        String str3 = "asd";
        System.out.println(str.equals(str2));
        System.out.println(str.equals(str3));
    }
    // 6. contains(CharSequence s)
    public static void exam6(){
        String str = "Hello";
        boolean b = str.contains("H");
        System.out.println(b);
    }
    // 7. replace
    public static void exam7(){
        String str = "Hello";
        System.out.println(str.replace("e","l"));
    }
    // 9. StringBuilder, StringBuffer
    public static void exam8(){
        StringBuilder str = new StringBuilder();
        str.append("Hello");
        str.append("Wolrd");
        System.out.println(str.toString());
    }
    // 10. reverse()
    public static void exam9(){
        String str = "hello";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse().toString();
        System.out.println(sb);

        System.out.println(new StringBuilder(str).reverse());
    }
    // 11. compareTo(String anotherString)
    public static void exam10(){
        String str = "hello";
        String str2 = "apple";
        String str3 = "hello";
        System.out.println(str.compareTo(str2));
        System.out.println(str.compareTo(str3));
    }
    // 12. toLowerCase() 및 to UpperCase()
    public static void exam11(){
        String str = "Hello Wolrd";
        String upper = str.toUpperCase();
        String lower = str.toLowerCase();
        System.out.println(upper);
        System.out.println(lower);
    }
    public static void main(String[] args) {
        exam10();
    }
}
