package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start; arr[i][1] = end;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int s = Integer.MIN_VALUE;
        int e = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<N; i++) {
            if(s < arr[i][0]) {
                sum += arr[i][1] - arr[i][0];
                s = arr[i][1];
            } else if(s >= arr[i][0] && s <= arr[i][1]){
                sum += arr[i][1] - s;
                s = arr[i][1];
            } else if(s >= arr[i][1]) {
//                s = arr[i][1];
            }
        }

        System.out.println(sum);
    }
}
