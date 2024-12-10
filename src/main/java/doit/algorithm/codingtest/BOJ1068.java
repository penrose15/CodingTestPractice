package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068 {
    static ArrayList<Integer>[] tree;
    static Set<Integer> deletedNodes = new HashSet<>();
    static int N;
    static int deletedNode;
    static boolean[] visited;
    static int leafNodeCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            tree[parent].add(i);
        }

        deletedNode = Integer.parseInt(br.readLine());
        deletedNodes.add(deletedNode);

        bfs(root);

        System.out.println(leafNodeCnt);
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        if (deletedNodes.contains(node)) return;

        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            int cnt = 0;
            for (int i = 0; i < tree[parent].size(); i++) {
                int child = tree[parent].get(i);

                if (deletedNodes.contains(child)) continue;

                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                    cnt++;
                }
            }

            if (cnt == 0) {
                leafNodeCnt++;
            }
        }
    }
}
