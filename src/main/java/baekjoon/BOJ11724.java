package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = 1;
            arr[end][start] = 1;
        }

//        int count = 0;
        boolean[] visited = new boolean[N+1];

        for(int i = 1; i<visited.length; i++) {
            if(!visited[i]) {
                dfs(arr, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }
    static int count = 0;
    public static void dfs(int[][] arr, boolean[] visited, int start) {
        if(visited[start]) {
            return;
        } else {
            visited[start] = true;
            for(int j = 1; j<arr[start].length; j++) {
                if(arr[start][j] == 1) {
                    dfs(arr, visited, j);
                }
            }
        }


    }
}
