package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int a = 0;
        int b = 0;
        int sum = 0;
        while (b <= N) {
            if (sum < N) {
                b += 1;
                sum += b;
            } else if (sum > N) {
                sum -= a;
                a += 1;
            } else {
                cnt++;
                b++;
                sum += b;
            }
        }
        System.out.println(cnt);

    }
}
