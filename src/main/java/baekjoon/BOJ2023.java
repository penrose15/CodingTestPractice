package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2023 {

    static int N;
    static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] sosu = new int[]{2,3,5,7};
        for(int i = 0; i<sosu.length; i++) {
            String firstNum = String.valueOf(sosu[i]);
            dfs(1, firstNum);
        }
        for(int i = 0; i<results.size(); i++) {
            System.out.println(results.get(i));
        }

    }

    static void dfs(int start, String number) {
        if(start == N) {
            results.add(Integer.parseInt(number));
            return;
        }

        for(int i = 1; i<10; i+=2) {
            String newStr = number + i;
            boolean isSosu = isSoSu(Integer.parseInt(newStr));
            if(isSosu) {
                dfs(start+1, newStr);
            }
            // 기존 number에 i append
            // 만약 소수라면 재귀 ㄱㄱ
        }
    }

    //소수 판별 메서드
    static boolean isSoSu(int n) {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        int div = (int) Math.sqrt(n);
        for(int i = 3; i<= div; i+=2) {
            if(n % i == 0) return false;
        }
        return true;
    }

}
