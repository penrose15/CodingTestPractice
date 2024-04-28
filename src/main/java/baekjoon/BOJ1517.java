package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1517 {
    static int[] arr, tmp;
    static long cnt = 0;
    // N 이 <= 500,000 이므로 시간복잡도가 O(n^2) 인 버블소트 스왑 개수는 int를 훌쩍 넘는다(...)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            tmp[i] = n;
        }
        mergeSort(0, N - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }

    public static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int pivot = (start + end) / 2;
        mergeSort(start, pivot);
        mergeSort(pivot + 1, end);

        sort(start, end, pivot);
        for(int i = start; i<=end; i++) {
            tmp[i] = arr[i];
        }

    }

    public static void sort(int start, int end, int mid) {
        int lo = start;
        int m = mid + 1;
        int idx = start;


        while (lo <= mid && m <= end) {
            if (tmp[lo] <= tmp[m]) {
                arr[idx] = tmp[lo];
                idx++;
                lo++;
            } else {
                arr[idx] = tmp[m];
                int move = m - idx;
                cnt += move;
                idx++;
                m++;
            }
        }

        if (lo <= mid) {
            while(lo <= mid) {
                arr[idx] = tmp[lo];
                lo++; idx++;
            }
        } else if (m <= end) {
            while(m <= end) {
                arr[idx] = tmp[m];
                m++; idx++;
            }
        }


    }

}


/*
* 3 2 8 1 7 4 5 6
*
* 3 | 2 | 8 | 1 | 7 | 4 | 5 | 6
*
* 2 3 | 1 8 | 4 7 | 5 6 -> 1 + 1 + 1
*
* 1 2 3 8 | 4 5 6 7 -> 2 + 1 + 1
*
* 1 2 3 4 5 6 7 8 -> 1 + 1+ 1 + 1
*
* */
