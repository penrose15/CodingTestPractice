package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        String[] arr = br.readLine().split(" ");
        int[] numArr = new int[N];

        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }

        int[] sumArr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + numArr[i-1];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            input = br.readLine();
            int start = Integer.parseInt(input.split(" ")[0]);
            int end = Integer.parseInt(input.split(" ")[1]);

            list.add(sumArr[end] - sumArr[start-1]);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

/*
5 3
5 4 3 2 1
1 3
2 4
5 5
* */