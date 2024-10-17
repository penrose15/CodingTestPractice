package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1016 {
    /*
     * 1 2 3   5 6 7     10
     * 11    13 14 15    17    19
     * 21 22 23       26       29 30
     * 31    33 34 35
     *
     * 2 3 5
     *
     * 4 8 12 16 20 24 28 32 36
     * 9 18 27 36
     * 25
     *
     *
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long sqrt = (long) Math.ceil(Math.sqrt((double) max));

        boolean[] arr = new boolean[(int) (max - min + 1)];

        for(long i = 2; i<=sqrt; i++) {
            long pow = i*i;
            long startIdx = min / pow;
            if(min % pow != 0) {
                startIdx++;
            }
            for(long j = startIdx; pow * j <= max; j++) {
                arr[(int) ((j * pow) - min)] = true;
            }
        }

        int cnt = 0;
        for(int i = 0; i<arr.length; i++) {
            if(!arr[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
