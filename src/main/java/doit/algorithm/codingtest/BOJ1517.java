package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1517 {
    static int[] arr, tmp;
    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] strArr = br.readLine().split(" ");
        arr = new int[N];
        tmp = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
            tmp[i] = arr[i];
        }
        mergeSort(0, N-1);

        System.out.println(cnt);
    }

    public static void mergeSort(int start, int end) {
        if(end - start < 1) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid+1, end);

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;

        while(idx1 <= mid && idx2 <= end) {
            if(tmp[idx1] <= tmp[idx2]) {
                arr[k] = tmp[idx1];
                k++; idx1++;
            } else {
                arr[k] = tmp[idx2];
                cnt += (idx2 - k);
                k++; idx2++;
            }
        }

        if(idx1 <= mid) {
            while(idx1 <= mid) {
                arr[k] = tmp[idx1];
                k++; idx1++;
            }
        }
        else if (idx2 <= end) {
            while(idx2 <= end) {
                arr[k] = tmp[idx2];
                k++; idx2++;
            }
        }

        for(int i = start; i<=end; i++) {
            tmp[i] = arr[i];
        }
    }
}

