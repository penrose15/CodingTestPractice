package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        int N = Integer.parseInt(nm.split(" ")[0]);
        int M = Integer.parseInt(nm.split(" ")[1]);

        String input = br.readLine();
        String[] strArr = input.split(" ");
        long[] arr = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Long.parseLong(strArr[i - 1]) % M;
        }

        long[] sumArr = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            sumArr[i] = (sumArr[i - 1] + arr[i]) % M;
        }

        long[] div = new long[M];
        for (int i = 1; i < N + 1; i++) {
            int a = (int) (sumArr[i] % M);
            div[a] += 1;
        }

        long result = 0;
        for (int i = 0; i < M; i++) {
            if (div[i] == 0) continue;
            if (i == 0) {
                if (div[i] > 1) {
                    result += div[i] + (div[i] * (div[i] - 1) / 2);
                }
            } else {
                result += div[i] * (div[i] - 1) / 2;
            }
        }
        System.out.println(result);

    }
}
