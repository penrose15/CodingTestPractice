package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {
    static int V;
    static int E;
    static int K;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int[] distArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, dist));
        }

        isVisited = new boolean[V + 1];
        distArr = new int[V + 1];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[K] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int start = node.node;

            if(distArr[start] < node.dist) continue;

            for (int i = 0; i < graph.get(start).size(); i++) {
                Node linkedNode = graph.get(start).get(i);
                int end = linkedNode.node;
                int endDist = linkedNode.dist;

                if (distArr[end] > node.dist + endDist) {
                    distArr[end] = node.dist + endDist;
                    queue.add(new Node(end, distArr[end]));
                }
            }
        }

        for(int i = 1; i<distArr.length; i++) {
            if(Integer.MAX_VALUE != distArr[i]) {
                System.out.println(distArr[i]);
            } else {
                System.out.println("INF");
            }
        }

    }

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
