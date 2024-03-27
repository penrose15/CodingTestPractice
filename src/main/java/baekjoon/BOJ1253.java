package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] A = new long[N];
        for(int i = 0; i<N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int cnt = 0;

        for(int i = 0; i<A.length; i++) {
            long num = A[i];
            int startIdx = 0;
            int endIdx = A.length - 1;
            while(startIdx < endIdx) {
                long sum = A[startIdx] + A[endIdx];
                if(sum > num) {
                    endIdx -= 1;
                } else if(sum < num) {
                    startIdx += 1;
                } else {
                    if(startIdx != i && endIdx != i) {
                        cnt += 1;
                        break;
                    } else if(startIdx == i){
                        startIdx += 1;
                    } else {
                        endIdx -= 1;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
/*
*
전체 범위를 돌면서 투 포인터를 통해 합이 같은지 확인
단, 서로 다른 숫자이어야 하므로 인덱스가 동일하면 안됨
예를 들어 A[1](= 0) + A[7](= n) = A[7](= n) 이면 안됨
*
* */