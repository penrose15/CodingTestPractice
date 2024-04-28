package baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ2751 {
    static int[] arr;
    static int[] sorted;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sorted = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, N-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : arr) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for(int i = start; i<=end; i++) {
            sorted[i] = arr[i];
        }

        sort(start, end, mid);
    }


    public static void sort(int start, int end, int mid) {
        int lo = start;
        int m = mid + 1;
        int idx = start;

        while (lo <= mid && m <= end) {
            if(sorted[lo] < sorted[m]) {
                arr[idx] = sorted[lo];
                lo++; idx++;
            }
            else {
                arr[idx] = sorted[m];
                m++; idx++;
            }
        }

        if(lo <= mid) {
            while (lo <= mid) {
                arr[idx] = sorted[lo];
                idx++; lo++;
            }
        } else if(m <= end) {
            while (m <= end) {
                arr[idx] = sorted[m];
                idx++; m++;
            }
        }

    }
}
