package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751 {
    static int N;
    static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, N-1);
        for(int i = 0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int start, int end) {
        if(end - start < 1) return;

        int pivot = (start + end) / 2;

        mergeSort(start, pivot);
        mergeSort(pivot + 1, end);

        for(int i = start; i<= end; i++) {
            tmp[i] = arr[i];
        }

        int k = start;
        int idx1 = start;
        int idx2 = pivot + 1;

        while(idx1 <= pivot && idx2 <= end) {
            if(tmp[idx1] < tmp[idx2]) {
                arr[k] = tmp[idx1];
                idx1++; k++;
            } else {
                arr[k] = tmp[idx2];
                idx2++; k++;
            }
        }

        while(idx1 <= pivot) {
            arr[k] = tmp[idx1];
            k++; idx1++;
        }
        while(idx2 <= end) {
            arr[k] = tmp[idx2];
            k++; idx2++;
        }
    }
}
