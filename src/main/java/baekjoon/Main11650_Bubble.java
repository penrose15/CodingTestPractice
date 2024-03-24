package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11650_Bubble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i< N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x; arr[i][1] = y;
        }

        int tmpx; int tmpy;
        //bubbleSort --> 시간초과
        for(int i = 0; i< arr.length; i++) {
            for(int j = 0; j<arr.length-i-1; j++) {
                if(arr[j][0] > arr[j+1][0]) {
                    tmpx = arr[j][0];
                    tmpy = arr[j][1];
                    arr[j][0] = arr[j+1][0];
                    arr[j][1] = arr[j+1][1];
                    arr[j+1][0] = tmpx;
                    arr[j+1][1] = tmpy;
                } else if (arr[j][0] == arr[j+1][0]) {
                    if(arr[j][1] > arr[j+1][1]) {
                        tmpx = arr[j][0];
                        tmpy = arr[j][1];
                        arr[j][0] = arr[j+1][0];
                        arr[j][1] = arr[j+1][1];
                        arr[j+1][0] = tmpx;
                        arr[j+1][1] = tmpy;
                    }
                }
            }
        }
        for (int[] ints : arr) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
