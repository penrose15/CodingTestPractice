package doit.algorithm.codingtest;

import java.io.*;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] inputArr = input.split(" ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        int[] resultArr = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i > -1; i--) {
            if (i == N - 1) {
                stack.push(arr[i]);
                resultArr[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > arr[i]) {
                    resultArr[i] = stack.peek();
                } else {
                    resultArr[i] = -1;
                }
                stack.push(arr[i]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(resultArr[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}

/*
3 5 2 7
* */
