package himedia.java;

import java.util.HashMap;
import java.util.Map;

public class test {


    public static void main(String[] args) {
        Map<String[], String[]> memberMap = new HashMap<>();
        memberMap.put(new String[]{"1","5"},new String[]{"a","e"});
        memberMap.put(new String[]{"2","6"},new String[]{"b","f"});
        memberMap.put(new String[]{"3","7"},new String[]{"c","g"});
        memberMap.put(new String[]{"4","8"},new String[]{"d","h"});

        for( String[] key : memberMap.keySet() ) {
            String[] infos = memberMap.get(key);
                System.out.println("[이름] " + infos[0] + ", [이메일] " + key[0] + ", [연락처] " + infos[1]);
            }
        }
    }


