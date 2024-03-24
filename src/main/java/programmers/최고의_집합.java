package programmers;

import java.util.Arrays;

public class 최고의_집합 {

    public static int[] solution(int n, int s) {

        if(n > s) {
            return new int[]{-1};
        }

        int start = s/n;
        int[] arr = new int[n];
        Arrays.fill(arr, start);

        int remain = s%n;

        for(int i = 0; i<remain; i++) {
            arr[i] += 1;
        }

        Arrays.sort(arr);

        return arr;

    }

    //백트래킹 --> 시간초과....
    /*static int[] result;
    public static int[] solution(int n, int s) {

        int[] arr1 = new int[s];
        for(int i = 0; i<s; i++) {
            arr1[i] = i+1;
        }
        int[] arr = new int[n];
        result = new int[n];
        dp(arr, arr1, s, n, 0, 0, s);

        if(result[0] != 0) {
            return result;
        } else {
            return new int[]{-1};
        }
    }

    static int max = -1;

    public static void dp(int[] arr, int[] arr1,int s, int n, int r, int a, int k) {
        if(n == r) {
            if(s < 0) {
                return;
            }
            if(a != k) {
                return;
            }
            int mul = 1;
            for(int i = 0; i<arr.length; i++) {
                mul *= arr[i];
            }
            if(max < mul) {
                max = mul;
                for(int i = 0; i<arr.length; i++) {
                    result[i] = arr[i];
                }
            }
            return;
        }

        for(int i = 0; i< arr1.length; i++) {
            arr[r] = arr1[i];
            dp(arr, arr1, s - arr[r], n, r+1, a + arr[r], k);
        }
    }*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 8)));
    }
}
