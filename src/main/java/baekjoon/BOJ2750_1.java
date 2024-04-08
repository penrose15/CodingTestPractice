package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2750_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<arr.length - 1; i++) {
            for(int j = 0; j<arr.length - i - 1; j++) {
                int a = arr[j];
                int b = arr[j+1];
                if(a > b) {
                    arr[j] = b;
                    arr[j+1] = a;
                }
            }
        }

        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}
