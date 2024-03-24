package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9663_2 {
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] chess = new int[N];
        Arrays.fill(chess, -1);

        for(int i = 0; i<N; i++) {
            chess[i] = 0;
            queen(1, chess,N-1);
            chess[i] = -1;
        }
        System.out.println(cnt);

    }
    /*
    * 0 1 2 3
    * 2 0 3 1
    * */
    static int cnt = 0;
    public static void queen(int val, int[] chess, int n) {
        if(n == 0) {
            cnt++;
            return;
        }
        for(int i = 0; i<N; i++) {
            //만약 배열이 -1이고
            if(chess[i] != -1) continue;
            //다른 배열과 숫자가 겹치지 않고
            for(int j = 0; j<N; j++) {
                if(chess[j] == val && i != j) continue;
            }
            //대각선으로도 안겹치면
            boolean check = true;
            int ti = i-1; int tval = val-1;
            while (ti >= 0 && tval >= 0) {
                if(chess[ti] == tval) {
                    check = false;
                    break;
                }
                ti -= 1; tval -=1;
            }
            if(!check) continue;
            ti = i-1; tval = val+1;
            while (ti >= 0 && tval <N) {
                if(chess[ti] == tval) {
                    check = false;
                    break;
                }
                ti -= 1; tval +=1;
            }
            if(!check) continue;
            ti = i+1; tval = val-1;
            while (ti < N && tval >= 0) {
                if(chess[ti] == tval) {
                    check = false;
                    break;
                }
                ti += 1; tval -=1;
            }
            if(!check) continue;
            ti = i+1; tval = val+1;
            while (ti < N && tval <N) {
                if(chess[ti] == tval) {
                    check = false;
                    break;
                }
                ti += 1; tval +=1;
            }
            if(!check) continue;

            chess[i] = val;
            queen(val + 1, chess, n-1);
            chess[i] = -1;
        }


    }
}
