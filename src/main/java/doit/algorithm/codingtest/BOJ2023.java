package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {
    static int N;
    static int[] firstDigitNum = new int[]{2, 3, 5, 7};
    static int[] digitNum = new int[]{1, 3, 7, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            for (int j : firstDigitNum) {
                System.out.println(j);
            }
            return;
        }

        for (int firstDigit : firstDigitNum) {
            dfs(firstDigit);
        }
    }

    static void dfs(int start) {
        if (calc(start) > N) {
            return;
        }

        for (int digit : digitNum) {
            int newNumber = start * 10 + digit;

            if (calc(newNumber) <= N && isDecimal(newNumber)) {
                if (calc(newNumber) == N) {
                    System.out.println(newNumber);
                }
                dfs(newNumber);
            }
        }
    }

    static int calc(int number) {
        if (number == 0) return 0;
        else {
            return (int) Math.log10(number) + 1;
        }
    }

    static boolean isDecimal(int number) {
        if (number % 2 == 0) return false;

        int sqrt = (int) Math.ceil(Math.sqrt(number));
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

/*
가장 첫번째 수는 {2,3,5,7}
이후의 숫자는 {1,3,5,7,9} 중 하나
* */
