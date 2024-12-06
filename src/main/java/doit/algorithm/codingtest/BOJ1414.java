package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1414 {
    static int N;
    static int lenCableLength = 0;
    static int minLenCableLength = 0;
    static int[] parent;
    static PriorityQueue<Edge> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        for(int i = 0; i<N; i++) {
            String st = br.readLine();
            for(int j = 0; j<N; j++) {
                char alphabet = st.charAt(j);
                int lenCable = getLenCableLength(alphabet);
                lenCableLength += lenCable;
                if(lenCable > 0) {
                    graph.add(new Edge(i + 1, j + 1, lenCable));
                }
            }
        }

        parent = new int[N+1];
        for(int i = 1; i<parent.length; i++) {
            parent[i] = i;
        }

        MST();

        for(int i = 1; i<parent.length-1; i++) {
            if(find(parent[i]) != find(parent[i+1])) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(lenCableLength - minLenCableLength);

    }

    static void MST() {
        while(!graph.isEmpty()) {
            Edge edge = graph.poll();

            if(find(edge.x) != find(edge.y)) {
                minLenCableLength += edge.cost;
                union(edge.x, edge.y);
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return parent[x];
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public static int getLenCableLength(char alphabet) {
        if(Character.isDigit(alphabet)) {
            return 0;
        }
        if(Character.isUpperCase(alphabet)) {
            return alphabet - 'A' + 27;
        } else {
            return alphabet - 'a' + 1;
        }
    }

    static class Edge {
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
