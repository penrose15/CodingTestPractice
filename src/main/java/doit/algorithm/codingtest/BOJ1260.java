package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static int N, M, V;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        for(int i = 0; i<N+1; i++) {
            Collections.sort(arr[i]);
        }

        sb = new StringBuilder();
        visited[V] = true;
        DFS(V);
        System.out.println(sb.toString());

        Arrays.fill(visited, false);
        sb = new StringBuilder();
        BFS();


    }

    static void DFS(int start) {
        sb.append(start + " ");

        for(int i = 0; i<arr[start].size(); i++) {
            int linkedNumber = arr[start].get(i);

            if(!visited[linkedNumber]) {
                visited[linkedNumber] = true;
                DFS(linkedNumber);
            }
        }
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            int start = queue.poll();
            sb.append(start + " ");

            for(int i = 0; i<arr[start].size(); i++) {
                int linkedNumber = arr[start].get(i);

                if(!visited[linkedNumber]) {
                    visited[linkedNumber] = true;
                    queue.add(linkedNumber);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
