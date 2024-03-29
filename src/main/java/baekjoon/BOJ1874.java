package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> result2 = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(int i = 0; i<n; i++) {
            int num2 = Integer.parseInt(br.readLine());
            if(num <= num2) {
                while(num <= num2) {
                    stack.push(num);
                    num += 1;
                    result2.add("+");
                }
                stack.pop();
                result2.add("-");
            } else {
                if(!stack.isEmpty() && stack.pop() > num2) {
                    System.out.println("NO");
                    return;
                }
                result2.add("-");
            }
        }

        result2.forEach(System.out::println);
    }
}
