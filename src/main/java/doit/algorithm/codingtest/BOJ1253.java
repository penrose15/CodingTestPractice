package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(inputArr[i]);
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            long sum = arr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start == i || end == i) {
                    if (start == i) start++;
                    else end--;
                } else {
                    if (arr[start] + arr[end] == sum) {
                        if (start != end) {
                            cnt++;
                            break;
                        } else {
                            end--;
                        }
                    } else if (arr[start] + arr[end] > sum) {
                        end--;
                    } else if (arr[start] + arr[end] < sum) {
                        start++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
/*
10
1 2 3 4 5 6 7 8 9 10
* */
