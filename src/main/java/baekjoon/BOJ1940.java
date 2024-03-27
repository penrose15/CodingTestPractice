package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        if(arr.length == 1) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        int start = 0;
        int end = arr.length-1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if(sum < M) {
                start += 1;
            } else {
                if(sum == M) cnt += 1;
                end -= 1;
            }
        }
        System.out.println(cnt);
    }
}
/*
*
6
9
2 7 4 1 5 3
* */
