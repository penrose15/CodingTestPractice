package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        StringTokenizer st;
        int[] arr = new int[501];
        Arrays.fill(arr, -1);
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b] = a;

            listA.add(a);
            listB.add(b);
        }

        int count = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != -1) {
                count++;
            }
        }
//        System.out.println(">>> count : " + count);
        int[] dp = new int[501];
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == -1) continue;
            dp[i] = 1;
            for(int j = 0; j<i; j++) {
                if(arr[j] == -1) continue;
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(count - dp[dp.length-1]);

    }
}
