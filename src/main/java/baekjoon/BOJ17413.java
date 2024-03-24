package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        // < 에서 > 까지는 스택에 넣지 않고
        //이외는 스택에 넣은 후 나중에 한번에 스택 비우기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) != '<') {
                while(i < str.length() && str.charAt(i) != '<') {
                    if(str.charAt(i) == ' ') {
                        while (!stack.isEmpty()) {
                            result.append(stack.pop());
                        }
                        result.append(str.charAt(i));
                        i++;
                    }
                    stack.push(str.charAt(i));
                    i++;
                }
                while(!stack.isEmpty()) {
                    result.append(stack.pop());
                }

                i--;
            } else {
                while (i < str.length() && str.charAt(i) != '>') {
                    result.append(str.charAt(i));
                    i++;
                }
                result.append(str.charAt(i));

            }
        }
        System.out.println(result);
    }
}
