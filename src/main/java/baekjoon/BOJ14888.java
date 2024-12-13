package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    /*
     * 브루트포스
     * 순열로 나열(백트래킹)
     * */
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operators = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calc(0, 1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(int cnt, int idx, int result) {
        if (cnt == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i] -= 1;
                int tmp = operation(result, arr[idx], i);
                calc(cnt + 1, idx + 1, tmp);
                operators[i] += 1;
            }
        }
    }

    static int operation(int result, int num, int idx) {
        if (idx == 0) {
            return result + num;
        }
        if (idx == 1) {
            return result - num;
        }
        if (idx == 2) {
            return result * num;
        }
        return result / num;
    }
}
