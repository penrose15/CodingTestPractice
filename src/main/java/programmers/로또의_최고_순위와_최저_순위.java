package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottoList = Arrays.stream(lottos)
                .boxed().collect(Collectors.toList());
        List<Integer> winNumberList = Arrays.stream(win_nums)
                .boxed().collect(Collectors.toList());

        int zero = 0;
        for (Integer integer : lottoList) {
            if(integer == 0) {
                zero++;
            }
        }
        int count = 0;
        for(int i = 0; i<winNumberList.size(); i++) {
            int win = winNumberList.get(i);
            if(lottoList.contains(win)) {
                count++;
            }
        }

        int minCount = count;
        int maxCount = zero + count;

        int minRank = rank(minCount);
        int maxRank = rank(maxCount);

        return new int[]{maxRank, minRank};

    }

    public int rank(int count) {
        if(count == 6) {
            return 1;
        }
        if(count == 5) {
            return 2;
        }
        if(count == 4) {
            return 3;
        }
        if(count == 3) {
            return 4;
        }
        if(count == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}
