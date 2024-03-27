package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] A = new long[N + 1];
        for(int i = 1; i < N + 1; i++) {
            int n = Integer.parseInt(st.nextToken());
            A[i] = n % M;
        }

        long[] S = new long[N + 1];
        long[] cntArr = new long[M];
        for(int i = 1; i < N + 1; i++) {
            S[i] = (A[i] + S[i-1]) % M;
            long n = cntArr[(int) S[i]];
            cntArr[(int) S[i]] = n + 1;
        }
        long result = 0;
        for(int i = 0; i< cntArr.length; i++) {
            long n = cntArr[i];
            if(n < 2) {
                continue;
            }
            result += (n * (n-1)) / 2;
        }
        long zero = 0;
        for(int i = 1; i< S.length; i++) {
            if(S[i] == 0) {
                zero += 1;
            }
        }
        result += zero;

        System.out.println(result);

    }
}
