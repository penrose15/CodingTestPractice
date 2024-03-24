package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        // input 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String[] strArr1 = input1.split(" ");
        int N = Integer.parseInt(strArr1[0]);
        int M = Integer.parseInt(strArr1[1]);

        int[][] arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            String input2 = br.readLine();
            String[] strArr2 = input2.split(" ");
            for (int j = 0; j < strArr2.length; j++) {
                arr[i][j+1] = Integer.parseInt(strArr2[j]);
            }
        }

        int[][] rangeArr = new int[M][4];

        for (int i = 0; i < M; i++) {
            String input3 = br.readLine();
            String[] strArr3 = input3.split(" ");
            rangeArr[i][0] = Integer.parseInt(strArr3[0]);
            rangeArr[i][1] = Integer.parseInt(strArr3[1]);
            rangeArr[i][2] = Integer.parseInt(strArr3[2]);
            rangeArr[i][3] = Integer.parseInt(strArr3[3]);
        }

        int[][] sumArr = new int[N + 1][N+1];
        // x 축에 대해 sum 배열 생성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
            }
        }


        for (int i = 0; i < M; i++) {
            int x1 = rangeArr[i][0];
            int y1 = rangeArr[i][1];
            int x2 = rangeArr[i][2];
            int y2 = rangeArr[i][3];
            int sum = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[y1-1][x1-1];

            System.out.println(sum);
        }

    }
}
