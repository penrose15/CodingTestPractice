package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = i+1;
        }

        int start = 0;
        int end = 0;
        int sum = 1;

        int result = 0;
        while(end < N) {
            if(sum < N) {
                end += 1;
                if(end >= N) break;
                sum += arr[end];
            }
            else if(sum > N) {
                sum -= arr[start];
                start += 1;
                if(start >= N) break;
            }
            else {
                result += 1;
                end += 1;
                if(end >= N) break;
                sum += arr[end];
            }
        }

        System.out.println(result);
    }
}
