package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1516 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] costs;
    static int[] answers;
    static int[] edgeCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        edgeCnt = new int[N + 1];
        answers = new int[N + 1];
        costs = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;

            while (st.hasMoreElements()) {
                int linkedNode = Integer.parseInt(st.nextToken());
                if (linkedNode == -1) break;
                graph[linkedNode].add(i);
                edgeCnt[i] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < edgeCnt.length; i++) {
            if (edgeCnt[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < graph[node].size(); i++) {
                int linkedNode = graph[node].get(i);
                edgeCnt[linkedNode] -= 1;
                answers[linkedNode] = Math.max(answers[linkedNode],answers[node] + costs[node]);
                if (edgeCnt[linkedNode] == 0) {
                    queue.add(linkedNode);
                }
            }
        }

        for (int i = 1; i<answers.length; i++) {
            System.out.println(answers[i] + costs[i]);
        }
    }
}
