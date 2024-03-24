package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main10773 {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        sc.nextLine();

        while(test>0) {
            int fool = sc.nextInt();
            sc.nextLine();
            stack.push(fool);

            if(fool == 0) {
                stack.pop();
                stack.pop();
            }
            test--;
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }

}
