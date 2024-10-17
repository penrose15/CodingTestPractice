package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = getGCD(a, b);
            int lcm = a * b / gcd;
            System.out.println(lcm);
        }
    }

    static int getGCD(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (a % b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return b;
    }

}
