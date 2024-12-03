package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {
    static int INF = 1000000001;
    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(i == j) continue;
                graph[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (graph[a][b] > c) graph[a][b] = c;
        }

        floyd();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    public static void floyd() {
        for (int m = 1; m < n + 1; m++) {
            for (int s = 1; s < n + 1; s++) {
                for (int e = 1; e < n + 1; e++) {
                    if(s == e || m == s || m == e) continue;
                    graph[s][e] = Math.min(graph[s][e], graph[s][m] + graph[m][e]);
                }
            }
        }
    }
}
