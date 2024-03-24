package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 과일_장수 {
    public int solution(int k, int m, int[] score) {
        int n = score.length / m;
        List<Integer> list = new ArrayList<>();

        for(int i =1; i<=n; i++) {
            list.add((i*m)-1);
        }

        List<Integer> s = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int max = 0;
        for (Integer integer : list) {
            max +=s.get(integer) * m;
        }
        return max;
    }
}
