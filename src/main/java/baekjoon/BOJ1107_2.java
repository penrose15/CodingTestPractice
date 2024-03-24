package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M == 0) {
            int result = Math.abs(N - 100);
            String str = String.valueOf(N);
            int len = str.length();

            result = Math.min(len, result);
            System.out.println(result);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] broken = new boolean[10];
        for(int i = 0; i<M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int result = Math.abs(N - 100);
        outer:
        for(int i = 0; i<= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBreak = false;
            for(int j = 0; j<str.length(); j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(N - i) + len;
                result = Math.min(result, min);
            }
        }
        System.out.println(result);
    }
}
