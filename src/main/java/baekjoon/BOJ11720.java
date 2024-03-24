package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int number  = Integer.parseInt(num);
        String input = br.readLine();
        String[] strArr = input.split("");

        int result = 0;
        for(int i = 0; i<number; i++) {
            result += Integer.parseInt(strArr[i]);
        }

        System.out.println(result);
    }
}
