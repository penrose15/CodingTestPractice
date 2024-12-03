package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753_2 {
    static int V;
    static int E;
    static int K;
    static ArrayList<Node>[] graph;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        arr = new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[K] = 0;

        for(int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int n = node.node;
            int dist = node.value;

            if(visited[n]) continue;
            visited[n] = true;

            for(int i = 0; i<graph[n].size(); i++) {
                Node newNode = graph[n].get(i);
                if(arr[newNode.node] > dist + newNode.value) {
                    arr[newNode.node] = dist + newNode.value;
                    queue.add(new Node(newNode.node, arr[newNode.node]));
                }
            }
        }

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(arr[i]);
            }
        }

    }

    static class Node {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
