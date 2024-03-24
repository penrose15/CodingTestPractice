package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

    static StringBuilder sb1 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] graph = new int[m+1][2];
        boolean[] visited = new boolean[n+1];

        for(int i = 1;i<=m;i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[n+1][n+1];

        for (int[] ints : graph) {
            int x = ints[0];
            int y = ints[1];

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        String resultBFS = bfs(arr, visited,v);

        Arrays.fill(visited,false);
        dfs(arr, visited, v);
        String resultDFS = sb1.toString();

        System.out.println(resultDFS);
        System.out.println(resultBFS);


    }


    public static void dfs(int[][] arr, boolean[] visited, int start) {

        sb1.append(start + " ");
        visited[start] = true;
        for(int i = 0; i<arr[start].length; i++) {

            if(!visited[i] && arr[start][i] == 1) {
                dfs(arr, visited, i);
            }
        }
    }

    public static String bfs(int[][] arr, boolean[] visited, int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");
            for(int i = 0; i< arr[node].length; i++) {
                if(!visited[i] && arr[node][i] == 1) {
                    visited[i] =true;
                    queue.offer(i);
                }
            }
        }
        return sb.toString();
    }
}
