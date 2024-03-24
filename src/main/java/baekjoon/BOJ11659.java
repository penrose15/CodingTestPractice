package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11659 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String[] strArr = input1.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        String input2 = br.readLine();
        String[] strArr2 = input2.split(" ");
        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(strArr2[i]);
        }

        int[][] sumRanges = new int[2][M];
        for(int i = 0; i<M; i++) {
            String input3 = br.readLine();
            String[] strArr3 = input3.split(" ");
            sumRanges[0][i] = Integer.parseInt(strArr3[0]);
            sumRanges[1][i] = Integer.parseInt(strArr3[1]);
        }

        int[] sumArr = new int[N+1];
        int sum = 0;
        for(int i = 1; i<N+1; i++) {
            sum += arr[i-1];
            sumArr[i] = sum;
        }

        for(int i = 0; i<M; i++) {
            int start = sumRanges[0][i] - 1;
            int end = sumRanges[1][i];

            int result = sumArr[end] - sumArr[start];
            System.out.println(result);
        }
    }
}
