package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1219 {
    static long MIN = Long.MIN_VALUE;
    static long MAX = Long.MAX_VALUE;
    static int N;
    static int M;
    static int S;
    static int E;
    static long[] dist;
    static boolean[] isMax;
    static long[] profits;
    static ArrayList<Edge> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Edge(s, e, -cost));
        }


        profits = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            profits[i] = Integer.parseInt(st.nextToken());
        }

        dist = new long[N];
        Arrays.fill(dist, MIN);
        dist[S] = profits[S];

        isMax = new boolean[N];

        for(int i = 0; i<N+50; i++) {
            for(int j = 0; j<M; j++) {
                Edge edge = graph.get(j);
                int s = edge.s;
                int e = edge.e;
                int cost = edge.cost;

                if(dist[s] == MIN) continue;
                else if(dist[s] == MAX) {
                    dist[e] = MAX;
                } else if (dist[e] < dist[s] + cost + profits[e]){
                    dist[e] = dist[s] + cost + profits[e];

                    if(i >= N - 1) dist[e] = MAX;
                }
            }
        }

        if(dist[E] == MIN) {
            System.out.println("gg");
            return;
        }

        if(dist[E] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(dist[E]);
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
