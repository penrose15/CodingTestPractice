package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//quick sort
public class BOJ11004 {
    static int[] A;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quick_sort(0, N-1);

        System.out.println(A[K-1]);
    }

    public static void quick_sort(int start, int end) {
        if(start >= end) return;

        int pivot = sort(start, end);
        quick_sort(start, pivot);
        quick_sort(pivot+1, end);
    }

    public static int sort(int start, int end) {
        int lo = start-1;
        int hi = end + 1;
        int pivot = A[(start + end)/2];

        while (true) {
            do {
                lo++;
            } while (A[lo] < pivot);

            do {
                hi--;
            } while (A[hi] > pivot);

            if(hi <= lo) return hi;
            swap(lo, hi);
        }
    }

    public static void swap(int lo, int hi) {
        int tmp = A[lo];
        A[lo] = A[hi];
        A[hi] = tmp;
    }

}
