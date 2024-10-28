package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long gcd = getGCD(A, B);

        if (C % gcd != 0) {
            System.out.println(-1);
            return;
        }

        long a = C / gcd;
        long[] arr = getXY(A, B);

        for (long l : arr) {
            System.out.print(a * l + " ");
        }
    }

    public static long getGCD(long A, long B) {
        if (A < B) {
            long tmp = A;
            A = B;
            B = tmp;
        }

        while (A % B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }

        return B;
    }

    public static long[] getXY(long A, long B) {
        if (A % B == 0) {
            return new long[]{0, 1};
        }

        long q = A / B;
        long r = A % B;

        long[] arr = getXY(B, r);
        long x = arr[1];
        long y = arr[0] - arr[1] * q;

        return new long[]{x, y};
    }
}
