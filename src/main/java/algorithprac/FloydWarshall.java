package algorithprac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydWarshall {
    static int INF = 1000000000;
    static int[][] graph;
    static int N = 5; // node
    static int M = 6; // edge

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];

        for(int i = 0; i<graph.length; i++) {
            for(int j = 0; j<graph.length; j++) {
                if(i == j) continue;
                graph[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v][w] = cost;
        }

        floyd();
    }

    public static void floyd() {
        for(int i = 1; i<N; i++) { // 경유지
            for(int j = 1; j<N; j++) { // 출발지
                for(int k = 1; k<N; k++) { // 도착지
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for(int i = 1; i<N; i++) {
            for(int j = 1; j<=N; j++) {
                if(graph[i][j] == INF) {
                    System.out.println(0 + " ");
                } else {
                    System.out.println(graph[i][j] + " ");
                }
            }
        }
    }
}
