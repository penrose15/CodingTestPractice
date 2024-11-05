package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    static int N;
    static int M;
    static int start;
    static int end;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
    }

    static void dijkstra(int start) {
        int[] dist = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node startNode = queue.poll();
            int idx = startNode.idx;

            if (idx == end) break;

            if (isVisited[idx]) continue;
            isVisited[idx] = true;

            for (int i = 0; i < graph[idx].size(); i++) {
                Node nextNode = graph[idx].get(i);

                if (dist[nextNode.idx] > dist[idx] + nextNode.cost) {
                    dist[nextNode.idx] = dist[idx] + nextNode.cost;
                    queue.add(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
