package baekjoon;

import java.util.Scanner;

public class Main2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        StringBuilder str3 = new StringBuilder();
        for(int i = str1.length()-1;i>=0;i--) {
            str3.append(str1.charAt(i));
        }
        StringBuilder str4 = new StringBuilder();
        for(int i = str1.length()-1;i>=0;i--) {
            str4.append(str2.charAt(i));
        }
        int a = Integer.parseInt(String.valueOf(str3));
        int b = Integer.parseInt(String.valueOf(str4));

        if(a>b) {
            System.out.println(a);
        }
        else System.out.println(b);
    }
}
