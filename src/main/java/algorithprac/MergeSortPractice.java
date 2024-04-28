package algorithprac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSortPractice {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0,N-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int start, int end) {
        if(end - start <= 1) return;

        int tmp = (end + start) / 2;

        mergeSort(start, tmp-1);
        mergeSort(tmp, end);

        int[] copied = Arrays.copyOf(arr,arr.length);
        sort(start, end, tmp, copied);
    }

    public static void sort(int start, int end, int mid, int[] sorted) {
        int left = start;
        int idx = start;
        int m = mid + 1;

        while(left <= mid && m <= end) {
            if(sorted[left] <= sorted[m]) {
                arr[idx] = sorted[left];
                left++; idx++;
            } else {
                arr[idx] = sorted[m];
                m++; idx++;
            }
        }

        if(left <= mid) {
            for(int i = left; i<=mid; i++) {
                arr[idx] = sorted[i];
                idx++;
            }
        } else if(m <= end){
            for(int i = m; i<=end; i++) {
                arr[idx] = sorted[i];
                idx++;
            }
        }

    }

    /*
    *
    * 5 4 3 1 2
    * 2 4 3 1 5
    * 2 1 3 4 5
    *
    *
    *
    * */
}
