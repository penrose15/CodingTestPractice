package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String c = br.readLine();
        int testcase = Integer.parseInt(c);

        for(int i = 0; i<testcase;i++) {
            String method = br.readLine();
            list.add(method);
        }
        for(int i = 0; i< list.size();i++) {
            if(list.get(i).trim().equals("top")){
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            } else if (list.get(i).trim().equals("pop")) {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if (list.get(i).trim().equals("size")) {
                System.out.println(stack.size());

            } else if (list.get(i).trim().equals("empty")) {
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);

            } else if (list.get(i).startsWith("push")) {
                String str = list.get(i).trim();
                String str2 = str.substring(5);
                //숫자가 1의 자리인것만 예상하고 substring(length()-1)해버려서 개고생 함;;
                int a = Integer.parseInt(str2);
                stack.push(a);

            }

        }

    }
}
