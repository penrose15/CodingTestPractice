package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1707 {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            color = new int[V+1];
            isVisited = new boolean[V+1];
            fillGraph(graph, V);

            Arrays.fill(color, -1);
            color[1] = 0;

            for(int j = 0; j<E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean result;
            String ans = "YES";
            for(int k = 1; k < V + 1; k++) {
                if(!isVisited[k]) {
                    result = bfs(k);
                    if(!result) {
                        ans = "NO";
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 0; i<graph[node].size(); i++) {
                int linkedNode = graph[node].get(i);
                if(color[linkedNode] != -1 && color[node] == color[linkedNode]) {
                    return false;
                }
                if(!isVisited[linkedNode]) {
                    isVisited[linkedNode] = true;
                    color[linkedNode] = changeColor(color[node]);
                    queue.add(linkedNode);
                }
            }

        }
        return true;
    }

    private static int changeColor(int color) {
        if(color == 1) {
            return 0;
        }
        return 1;
    }

    private static void fillGraph(ArrayList[] graph, int V) {
        for(int k = 0; k< V +1; k++) {
            graph[k] = new ArrayList<>();
        }
    }
}
