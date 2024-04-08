package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] strArr = str.toCharArray();
        int[] arr = new int[strArr.length];

        for(int i = 0; i< strArr.length; i++) {
            arr[i] = strArr[i] - '0';
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.length; i++) {
            int max = -1;
            int maxIdx = i;
            for(int j = i; j<arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = max;
            arr[maxIdx] = tmp;
            sb.append(max);
        }
        System.out.println(sb);
    }
}
