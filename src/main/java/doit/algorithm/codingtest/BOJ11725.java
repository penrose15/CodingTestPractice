package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    static ArrayList<Integer>[] tree;
    static int N;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        parents = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st;
        for(int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        for(int i = 1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }

        for(int i = 2; i<parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int node) {
        for(int i = 0; i<tree[node].size(); i++) {
            int k = tree[node].get(i);
            if(!visited[k]) {
                visited[k] = true;
                parents[k] = node;
                dfs(k);
            }
        }
    }
}
