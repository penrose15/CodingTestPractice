package programmers;

import java.util.*;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<numbers.length-1; i++) {
            for(int j = i+1; j< numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());

        int[] arr = list.stream().mapToInt(i->i).toArray();

        return arr;
    }
}
