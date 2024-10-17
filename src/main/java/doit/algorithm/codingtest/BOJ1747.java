package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(!(isPrime(N) && isPelindrom(N))) {
            N++;
        }

        System.out.println(N);
    }

    static boolean isPrime (int n) {
        int sqrt = (int) Math.ceil(Math.sqrt(n));

        if(n < 2) return false;
        if(n == 2 || n == 3) return true;

        if(n % 2 == 0) {
            return false;
        }

        for(int i = 3; i<=sqrt; i+=2) {
            if(n % i == 0) return false;
        }
        return true;
    }

    static boolean isPelindrom(int n) {
        String str = String.valueOf(n);

        char[] ch = str.toCharArray();
        for(int i = 0; i<ch.length; i++) {
            if(ch[i] != ch[ch.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}
