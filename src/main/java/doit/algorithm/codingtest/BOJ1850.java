package doit.algorithm.codingtest;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcdDigit = getGCD(A, B);


        StringBuilder sb = new  StringBuilder();
        for(long i = 1; i<=gcdDigit; i++) {
            sb.append(1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    static long getGCD(long A, long B) {
        if(A < B) {
            long tmp = A;
            A = B;
            B = tmp;
        }

        while(A % B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }

        return B;
    }



    /*
    * 9 3
    * 6
    * 111111111 111
    * -> 111 * 100000 + 111111
    * -> 111 * 100000 + 111 * 1000 + 111
    *
    * 9 4
    * 5
    * 111111111 1111
    * -> 1111 * 100000 + 11111
    * -> 1111 * 100000 + 1111 * 10 + 1
    *
     * 9 2
     * 7
     * 111111111 11
     * -> 11 * 10000000 + 1111111
     * -> 11 * 10000000 + 11 * 10000 + 11111
     * -> 11 * 10000000 + 11 * 10000 + 11 * 1000 + 111
     * -> 11 * 10000000 + 11 * 10000 + 11 * 1000 + 11 * 10 + 1
    *
    *
    * */
}
