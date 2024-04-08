package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Num> list = new ArrayList<>();

        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(new Num(num, i));
        }
        list.sort(Comparator.comparingInt(a -> a.num));


        int max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++) {
            Num n = list.get(i);
            int sortedIdx = n.idx;
            int n1 = sortedIdx - i;

            if(max < n1) {
                max = n1;
            }
        }
        int result = max + 1;
        System.out.println(result);

    }

    static class Num {
        int num;
        int idx;

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}

/*
* bubble sort swap로 인해 sort 1회 시 왼쪽으로는 최대 1칸만 이동 가능하다
* 즉, 초기의 arr과 sort가 끝난 arr을 비교하기 위해서는
* 초기의 arr의 idx 중 가장 멀리 왼쪽으로 이동한 idx간의 차 + 1을 하면 된다
*
* */
