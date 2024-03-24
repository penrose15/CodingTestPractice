package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2011 {


    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp = new int[str.length() + 1];
        dp[0] = 1;


        System.out.println(dp(dp.length, str));


    }
    /*
    * 25114
    *
    * 2511 + 4
    * 251 + 14
    *
    * */

    public static long dp(int length, String str) {
        for(int i = 1; i<length; i++) {
            if(str.charAt(str.length()-i) != '0') {
                dp[i] = (dp[i] + dp[i-1])% 1000000;


            }
            if(i > 1) {
                if(!str.startsWith("00", str.length()-i)) {
                    String str2 = str.substring(str.length()-i, str.length()-i + 2);
                    int num1 = Integer.parseInt(str2);
                    if(num1 >= 10 && num1 <=26) {
                        dp[i] = (dp[i] + dp[i-2]) % 1000000;
                    } else if(str.length()-i == 0 && str2.charAt(1) == '0') {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
        return dp[length-1]% 1000000;
    }
}
