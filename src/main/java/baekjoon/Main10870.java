package baekjoon;

import java.util.Scanner;

public class Main10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ss = sc.nextInt();
        System.out.println(AA.method(ss));
    }
    public static class AA {
        public static int method(int n) {
            if(n==0) return 0;
            else if(n == 1 || n == 2) return 1;
            else {
                return method(n-1)+method(n-2);
            }

        }
    }
}
