package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11047 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for(int i = 0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int cnt = 0;
        for(int i = coins.length-1; i > -1; i--) {
            int coin = coins[i];
            if(K < coin) {
                continue;
            } else {
                if(K / coin > 0) {
                    cnt += K / coin;
                    K = K % coin;
                }
                if(K == 0) break;
            }
        }

        System.out.println(cnt);
    }
}
