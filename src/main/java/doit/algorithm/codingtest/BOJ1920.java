package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int ans = binarySearch(num);
            System.out.println(ans);
        }
    }

    static int binarySearch(int number) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        int result = 0;
        do {
            mid = (start + end)/2;
            if(arr[mid] < number) {
                start = mid+1;
            } else if (arr[mid] > number) {
                end = mid-1;
            } else {
                result = 1;
                break;
            }

        } while (start <= end);
        return result;
    }
}
