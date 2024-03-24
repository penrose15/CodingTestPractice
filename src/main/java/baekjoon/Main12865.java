package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //물건 개수
        int k = Integer.parseInt(st.nextToken()); //최대 무게
        int[][] dp = new int[n+1][k+1];
        int[] w = new int[n+1]; //물건의 무게들
        int[] v = new int[n+1]; //물건의 가치들

        for(int i = 1; i<= n;i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=k;j++) {
                if(w[i]<=j) {
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[n][k]);
    }
}
