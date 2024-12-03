package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11403 {
    static int INF = 1000000001;
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];

        for(int i = 1; i<N+1; i++) {
            for(int j = 1; j<N+1; j++) {
                if(i == j) continue;
                graph[i][j] = INF;
            }
        }

        StringTokenizer st;
        for(int i = 1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<N+1; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
            }
        }

        for(int i = 1; i<graph.length; i++) {
            for(int j = 1; j<graph.length; j++) {
                for(int k = 1; k<graph.length; k++) {
                    if(graph[j][k] == 0) {
                        if(graph[j][i] == 1 && graph[i][k] == 1) {
                            graph[j][k] = 1;
                        }
                    }
                }
            }
        }

        for(int i = 1; i<N+1; i++) {
            for(int j = 1; j<N+1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
