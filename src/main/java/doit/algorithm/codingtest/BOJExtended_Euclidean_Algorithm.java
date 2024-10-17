package doit.algorithm.codingtest;

import java.io.IOException;
import java.util.Arrays;

public class BOJExtended_Euclidean_Algorithm {
    public static void main(String[] args) throws IOException {

    int a = 56;
    int b = 15;

    int gcd = gcd(a, b);

    int[] ret = ecd(a, b);
    System.out.println(Arrays.toString(ret));

    }

    public static int[] ecd(int a, int b) {
        int[] ret = new int[2];
        if(b == 0) {
            ret[0] = 0; ret[1] = 1;
            return ret;
        }

        int q = a / b;
        int[] v = ecd(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    public static int gcd(int a, int b) {
        while(a % b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return b;
    }
}
