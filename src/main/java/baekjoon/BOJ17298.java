package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        /*
        * 3 5 2 7
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];
        Arrays.fill(result, -1);
        for(int i = 0; i<N; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                int n1 = stack.peek();
                if(arr[n1] > arr[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                        result[stack.peek()] = arr[i];
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(r -> sb.append(r).append(" "));
        String r = sb.toString().trim();
        System.out.println(r);
    }
}

/*
* 3 5 2 7
* 0 1 2 3
*
* 5 7 7 -1
*
* 9 5 4 8
* 0 1 2 3
*
* 0 3
*
*
* */
