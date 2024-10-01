package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11004 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);

        input = br.readLine();
        String[] strArr = input.split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        quickSort(0, N - 1, K-1);

        System.out.println(arr[K - 1]);
    }

    public static void quickSort(int start, int end, int K) {
        if(start >= end) return;

        int pivot = sort(start, end);

        if(pivot == K) {
        }
        else if(pivot > K) {
            quickSort(start, pivot, K);
        } else {
            quickSort(pivot+1, end, K);
        }
    }

    public static int sort (int start, int end) {
        int lo = start;
        int hi = end;
        int pivot = (start + end) / 2;
        int pivotValue = arr[pivot];

        while(lo < hi) {
            while (lo < hi && arr[lo] < pivotValue) {
                lo++;
            }
            while (lo < hi && arr[hi] > pivotValue) {
                hi--;
            }
            swap(lo, hi);
        }
        return hi;
    }

    private static void swap(int lo, int hi) {
        int tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
    }
}
