package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {
    static int N;
    static int M;
    static int[] edgeCnt;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeCnt = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            edgeCnt[e] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < edgeCnt.length; i++) {
            if (edgeCnt[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");

            for (int i = 0; i < graph[node].size(); i++) {
                int linkedNode = graph[node].get(i);
                edgeCnt[linkedNode] -= 1;
                if (edgeCnt[linkedNode] == 0) {
                    queue.add(linkedNode);
                }
            }
        }
        System.out.println(sb);
    }
}
