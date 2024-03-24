package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2293_2트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        int[] coin = new int[n];
        for(int i = 0; i< coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[coin.length][k+1];

        for(int i = 0; i< coin.length; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i<k+1; i++) {
            if(i % coin[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i<dp.length; i++) {
            for(int j = 1; j< dp[i].length; j++) {
                if(j < coin[i]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
                }
            }
        }

        System.out.println(dp[coin.length-1][k]);
        for(int i = 0; i< coin.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
