package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10814 {
    static int N;
    static int K;
    static int CNT = 0;
    static int A[];
    static int tmp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NK = br.readLine();
        N = Integer.parseInt(NK.split(" ")[0]);
        K = Integer.parseInt(NK.split(" ")[1]);

        String input = br.readLine();
        String[] inputArr = input.split(" ");

        A = new int[N]; tmp = new int[N];

        for(int i = 0; i<N; i++) {
            int number = Integer.parseInt(inputArr[i]);
            A[i] = number; tmp[i] = number;
        }

        mergeSort(0, N-1);

        if(CNT < K) {
            System.out.println(-1);
        }

    }

    static void mergeSort(int start, int end) {
        if(end - start < 1) return;

        int pivot = (start + end) / 2;

        int lo = start;
        int hi = pivot + 1;
        int k = start;

        mergeSort(start, pivot);
        mergeSort(pivot + 1, end);

        while(lo <= pivot && hi <= end) {
            if(A[lo] < A[hi]) {
                tmp[k] = A[lo];
                k++; lo++;
            } else {
                tmp[k] = A[hi];
                k++; hi++;
            }
        }

        while (lo <= pivot) {
            tmp[k] = A[lo];
            k++; lo++;
        }
        while (hi <= end) {
            tmp[k] = A[hi];
            k++; hi++;
        }

        for(int i = start; i <= end; i++) {
            CNT++;
            if(CNT == K) {
                System.out.println(tmp[i]);
                A[i] = tmp[i];
                return;
            }
            A[i] = tmp[i];
        }
    }
}
