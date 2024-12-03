package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 {
    static int INF = 1000000001;
    static int N;
    static int M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 1; i<N+1; i++) {
            for(int j = 1; j<N+1; j++) {
                if(i == j) continue;
                graph[i][j] = INF;
            }
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        for(int i = 1; i<N+1; i++) {
            for(int j = 1; j<N+1; j++) {
                for(int k = 1; k<N+1; k++) {
                    if(graph[j][i] != INF && graph[i][k] != INF) {
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                    }
                }
            }
        }

        int idx = 0;
        int min = INF;
        for(int i = 1; i<N+1; i++) {
            int tmp = 0;
            for(int j = 1; j<N+1; j++) {
                if(i == j) continue;
                if(graph[i][j] != INF) {
                    tmp += graph[i][j];
                }
            }
            if(tmp < min) {
                idx = i;
                min = tmp;
            }
        }

        System.out.println(idx);
    }
}
