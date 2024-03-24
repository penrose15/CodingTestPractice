package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        str = str.toUpperCase();
        char[] ch = str.toCharArray();
        HashMap<Character,Integer> hashmap = new HashMap<>();

        for(char c : ch) {
            if(hashmap.containsKey(c)) {
                hashmap.put(c,hashmap.get(c)+1);
            }
            else {
                hashmap.put(c,0);
            }
        }
        int max2 = 0;
        for (Entry<Character, Integer> map : hashmap.entrySet()) {
            if (map.getValue() > max2) {
                max2 = map.getValue();
            }
        }
        Main1157 m = new Main1157();
        if (m.getKey(hashmap, max2) == '0') {
            System.out.println("?");
        } else {

            System.out.println(m.getKey(hashmap, max2));
        }


    }

    public Character getKey(HashMap<Character, Integer> map, Integer value) {
        int count = 0;
        for (Character key : map.keySet()) {
            if (value.equals((map.get(key)))) {
                count++;
            }

        }
        if (count > 1) return '0';
        else {
            for (Character key : map.keySet()) {
                if (value.equals((map.get(key)))) {
                    return key;
                }
            }return null;
        }

    }
}
