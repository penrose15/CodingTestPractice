package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체
public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N+1];

        boolean[] isNotPrime1 = new boolean[N+1];

        for(int i = 1; i<=N; i++) {
            arr1[i] = i;
        }

        int sqrt = (int) Math.ceil(Math.sqrt(N));

        int start = M;

        for(int i = 1; i<=sqrt; i++) {
            if(arr1[i] < 2) {
                isNotPrime1[i] = true;
            }
            else {
                if (isNotPrime1[i]) {
                    continue;
                }
                else {
                    for(int j = i+i; j<arr1.length; j+=i) {
                        isNotPrime1[j] = true;
                    }
                }
            }
        }

        for(int i = 1; i<isNotPrime1.length; i++) {
            if(!isNotPrime1[i] && i >= start) {
                System.out.println(arr1[i]);
            }
        }
    }
}
