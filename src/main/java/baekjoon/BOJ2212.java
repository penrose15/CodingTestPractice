package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int[] locations = new int[N];
        for(int i = 0; i<N; i++) {
            locations[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(locations);

        /*
        * 1 3 3 6 7 9
        *
        * 좌표 간의 거리를 구한다
        *
        * 이중 긴 거리 순으로 K-1개를 고른다
        *
        * 이후 거리를 합한다
        *
        * */
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<N; i++) {
            int dist = locations[i] - locations[i-1];
            list.add(dist);
        }
        list.sort(Comparator.reverseOrder());
        int sum = 0;
        int length = locations[locations.length-1] - locations[0];
        if(K == 1) {
            System.out.println(length);
            return;
        }

        if(K > N) {
            System.out.println(0);
            return;
        }

        for(int i = 1; i<K; i++) {
            sum += list.get(i-1);
        }


        System.out.println(length - sum);

    }
}
