package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 삽입정렬 활용
public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i<N; i++) {
            for(int j = i-1; j>= 0; j--) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int result = 0;
        for(int i = 0; i<N; i++) {
            int sum = 0;
            for(int j = 0; j<=i; j++) {
                sum += arr[j];
            }
            result += sum;
        }
        System.out.println(result);
    }
/*
5
3 1 4 3 2
*
*
* */
}
