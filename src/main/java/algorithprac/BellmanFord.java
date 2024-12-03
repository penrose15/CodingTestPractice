package algorithprac;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 그래프 최단 경로 구하는 알고리즘
 * 하나의 정점에서 최단거리
 * 음수 사이클 x
 * 음수 가중치 가능
 *
 * dist[] 출발지는 0, 나머지는 INF로 초기화
 * 간선의 가중치(cost(v, w))
 * dist[v] 가 무한대라면 아래를 진행
 *   dist[v] = min(dist[v], dist[w] + cost(w, v))
 * */
public class BellmanFord {
    static int[] dist;
    static ArrayList<Edge> graph;

    public static void main(String[] args) {
        int start = 1;
        int n = 5; // node 개수
        int e = 6; // edge 개수
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < e; j++) {
                Edge edge = graph.get(j);

                if(dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            Edge edge = graph.get(i);

            if(dist[edge.v] != Integer.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
                System.out.println("음수 사이클 존재함");
                return;
            }
        }

        for(int i = 1; i<dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }

    }

    static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
}
