package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;

        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for(long i = 1; i<=N; i++) {
                long min = Math.min(N, mid / i);
                cnt += min;
            }

            if(cnt >= K) {
                result = mid;
                end = mid -1 ;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
