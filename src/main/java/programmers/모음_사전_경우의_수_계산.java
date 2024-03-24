package programmers;

import java.util.*;

public class 모음_사전_경우의_수_계산 {

    public int solution(String word) {
        String[] arr = new String[]{"A","E","I","O","U"};
        String[] str = word.split("");

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("E", 1);
        map.put("I", 2);
        map.put("O", 3);
        map.put("U", 4);

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, 781);
        map1.put(1, 156);
        map1.put(2, 31);
        map1.put(3, 6);
        map1.put(4,1);

//        int depth = str.length;
        int sum = 0;
        for(int i = 0; i<str.length; i++) {
            int depth = i;
            int num = map.get(str[i]);
            sum += num * map1.get(depth) + 1;
        }
        return sum;
    }
}
