package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String test1 = br.readLine();
        int test = Integer.parseInt(test1);
        int[] arr = new int[test];
        for(int i = 0; i<test;i++) {
            String number = br.readLine();
            String[] sp = number.split(" ");
            int a = Integer.parseInt(sp[0]);
            int b = Integer.parseInt(sp[1]);
            arr[i] = a+b;
        }
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
