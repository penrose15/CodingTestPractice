package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1854 {
    static boolean[][] isVisited;
    static ArrayList<Node>[] graph;
    static int n;
    static int m;
    static int k;
    static PriorityQueue<Integer>[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }
        dijkstra();

        for(int i = 1; i<dist.length; i++) {
            PriorityQueue<Integer> d = dist[i];

            if(d.size() == k) {
                System.out.println(d.poll());
            } else {
                System.out.println(-1);
            }
        }

    }

    static void dijkstra() {
        isVisited = new boolean[n+1][n+1];
        dist = new PriorityQueue[n+1];
        for(int i = 0; i<n+1; i++) {
            dist[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }
        dist[1].add(0);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int idx = node.index;

            for(int i = 0; i<graph[idx].size(); i++) {
                Node nextNode = graph[idx].get(i);

                if(dist[nextNode.index].size() < k) {
                    int distNextCost = node.cost + nextNode.cost;
                    dist[nextNode.index].add(distNextCost);
                    queue.add(new Node(nextNode.index, distNextCost));
                } else if(dist[nextNode.index].peek() > node.cost + nextNode.cost) {
                    dist[nextNode.index].poll();
                    int distNextCost = node.cost + nextNode.cost;
                    dist[nextNode.index].add(distNextCost);
                    queue.add(new Node(nextNode.index, distNextCost));
                }

            }
        }
    }

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
