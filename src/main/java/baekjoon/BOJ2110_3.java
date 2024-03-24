package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[arr.length-1] - arr[0];
        int ans = Integer.MAX_VALUE;
        while(min <= max) {
            int mid = (min + max) / 2;
            int s = 0;
            int cnt = 1;
            int length;
            for(int i = 1; i<arr.length; i++) {
                length = arr[i] - arr[s];

                if(length >= mid) {
                    s = i;
                    cnt += 1;
                }
            }

            if(cnt >= C) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
