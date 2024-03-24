package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long min = 1;
        long max = (long) N *(long)N;

        while (min <= max) {
            long mid = (min + max) / 2;

            long sum = 0;
            for(int i = 1; i<=N; i++) {
                long tmp = Math.min(mid/i, N);
                sum += tmp;
            }

            if(sum < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}
