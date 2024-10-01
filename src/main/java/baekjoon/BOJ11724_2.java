package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS
public class BOJ11724_2 {
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        int cnt = 0;
        for(int i = 1; i< visited.length; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    static void dfs(int s) {
        if(visited[s]) {
            return;
        }
        visited[s] = true;
        for(int i = 1; i<arr[s].length; i++) {
            if(arr[s][i] == 1) {
                dfs(i);
            }
        }
    }
}
