package baekjoon;

import java.util.Scanner;

public class Main10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(Fuck1.method(k));
        ;
    }
    public static class Fuck1{

        public static int method(int a) {
            if(a == 1) return a;
            else if (a==0) {return 1;

            } else {
                return a*method(a-1);
            }
        }
    }
}
