package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ13023 {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visited;
    static boolean ABCDE = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        for(int i = 0; i<N; i++) {
            if(!visited[i]) {
                dfs(i, 1);
                if(ABCDE) {
                    System.out.println(1);
                    return;
                }
            }
//            Arrays.fill(visited, false);
        }
        System.out.println(0);

    }

    static void dfs(int s, int cnt) {
        if(cnt == 5) {
            ABCDE = true;
            return;
        }
        visited[s] = true;
        for(int i = 0; i<arr[s].length; i++) {
            if(!visited[i]) {
                if(arr[s][i] == 1) {
                    dfs(i, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

/*

8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7

====

5 5
0 1
1 2
2 3
3 0
1 4


* */
