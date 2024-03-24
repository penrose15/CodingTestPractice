package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] dp = new int[k+1];

        for(int i = 0; i<n; i++) {
            Arrays.fill(dp, Integer.MAX_VALUE-1);
        }
        dp[0] = 0;
        for(int i = 0; i<n; i++) {
            for(int j = arr[i]; j<k+1; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
//        for(int i = 0; i<n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        if(dp[k] == Integer.MAX_VALUE-1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }

    }
}
