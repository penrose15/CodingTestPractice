package baekjoon;

import java.io.*;

public class BOJ10989_cnt_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] A = new int[10001];
        for(int i = 0; i<N; i++) {
            A[arr[i]] += 1;
        }

        for(int i = 1; i<A.length; i++) {
            A[i] += A[i-1];
        }

        int[] result = new int[N];
        for(int i = N-1; i>=0; i--) {
            int n = A[arr[i]];
            result[n-1] = arr[i];
            A[arr[i]] -= 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<N; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();;

    }
}
