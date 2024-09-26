package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        int plus = 0;
        int minus = 0;

        int n = 1;
        for (int i = 0; i < N; i++) {
            if (n <= N) {
                if (stack.isEmpty()) {
                    stack.push(n);
                    n++;
                    list.add("+");
                }
                while (stack.peek() < arr[i]) {
                    stack.push(n);
                    n++;
                    list.add("+");
                    plus++;
                }
            }
            if (stack.peek() == arr[i]) {
                stack.pop();
                list.add("-");
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}

/*
8
4
3
6
8
7
5
2
1

수열의 숫자가 자연수보다 크거나 같으면 : stack에 해당 자연수를 추가하고 자연수++
수열의 숫자가 자연수와 작으면 : stack에서 pop() 하고 수열의 다음 번호로 넘어간다

* */
