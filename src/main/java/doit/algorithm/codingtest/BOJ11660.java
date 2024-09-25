package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        int N = Integer.parseInt(nm.split(" ")[0]);
        int M = Integer.parseInt(nm.split(" ")[1]);

        int[][] square = new int[N][N];

        for(int i = 0; i<N; i++) {
            String input = br.readLine();
            String[] numArr = input.split(" ");
            for(int j  =0; j<N; j++) {
                square[i][j] = Integer.parseInt(numArr[j]);
            }
        }

        int[][] sumArr = new int[N+1][N+1];
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=N; j++) {
                sumArr[i][j] = square[i-1][j-1] + sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1];
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<M; i++) {
            String input = br.readLine();
            String[] numArr = input.split(" ");

            int x1 = Integer.parseInt(numArr[0]);
            int y1 = Integer.parseInt(numArr[1]);
            int x2 = Integer.parseInt(numArr[2]);
            int y2 = Integer.parseInt(numArr[3]);

            int result = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
            list.add(result);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
* */
