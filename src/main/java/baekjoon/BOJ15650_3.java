package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15650_3 {
    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = i+1;
        }

        int[] result = new int[M];
        back_tracking(0,0,result);

        for (String s : list) {
            System.out.println(s);
        }

    }

    public static void back_tracking(int n, int c, int[] result) {
        if(c == M) {
            sb = new StringBuilder();
            for (int j : result) {
                sb.append(j).append(" ");
            }
            list.add(sb.toString());
            return;
        }

        for(int i = n; i<N; i++) {
            int num = arr[i];
            result[c] = num;

            back_tracking(i+1, c+1,result);

        }
    }
}
