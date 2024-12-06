package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1197 {
    static int V;
    static int E;
    static long[] parents;
    static long[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new long[E][3];
        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, Comparator.comparingLong(o1 -> o1[2]));

        parents = new long[V + 1];
        for(int i = 1; i<parents.length; i++) {
            parents[i] = i;
        }

        kruskal();
    }

    static void kruskal() {
        long cost = 0;
        for(int i = 0; i<E; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                cost += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        System.out.println(cost);
    }

    static void union(long x, long y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parents[(int) y] = x;
        } else {
            parents[(int) x] = y;
        }
    }

    static long find(long x) {
        if(parents[(int) x] == x) return parents[(int) x];
        else {
            parents[(int) x] = find(parents[(int) x]);
            return parents[(int) x];
        }
    }
}
