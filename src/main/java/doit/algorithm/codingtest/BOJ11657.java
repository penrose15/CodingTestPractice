package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {
    static ArrayList<Edge> graph;
    static long[] dist;
    static int N;
    static int M;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Edge(s, e, cost));
        }

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                Edge edge = graph.get(j);

                if(dist[edge.s] != INF && dist[edge.e] > dist[edge.s] + edge.cost) {
                    dist[edge.e] = dist[edge.s] + edge.cost;
                }
            }
        }

        for(int i = 0; i<M; i++) {
            Edge edge = graph.get(i);

            if(dist[edge.s] != INF && dist[edge.e] > dist[edge.s] + edge.cost) {
                System.out.println(-1);
                return;
            }
        }

        for(int i = 1; i<dist.length; i++) {
            if(i == 1) continue;
            if(dist[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static class Edge {
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
