package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        List<Long> primeList = new ArrayList<>();

        int sqrt = (int) Math.ceil(Math.sqrt(end));
        int sqrtSqrt = (int) Math.ceil(Math.sqrt(sqrt));

        long[] arr = new long[sqrt+1];
        for(int i = 1; i<arr.length; i++) {
            arr[i] = i;
        }

        for(int i = 2; i<= sqrtSqrt; i++) {
            if(arr[i] == 0) continue;
            for(int j = i+i; j<=sqrt; j+= i) {
                arr[j] = 0;
            }
        }

        int idx = 2;
        int cnt = 0;
        int square = 2;
        while(idx < arr.length) {
            long n = arr[idx];
            if(arr[idx] == 0) {
                idx+=1; continue;
            }
            while(Math.pow(n, square) <= end) {
                if(Math.pow(n, square) >= start) {
                    cnt+=1;
                    square+=1;
                } else {
                    square+=1;
                }
            }
            square = 2;
            idx+=1;
        }

        System.out.println(cnt);
    }
}
