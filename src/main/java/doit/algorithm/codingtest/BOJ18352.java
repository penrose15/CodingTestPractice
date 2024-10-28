package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352 {
    static int N; static int M;
    static int K; static int X;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[s].add(e);
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{X, 0}); visited[X] = true;

        List<Integer> cities = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer[] arr = queue.poll();
            int start = arr[0];
            int dist = arr[1];

            if(dist == K) {
                cities.add(start);
                continue;
            }

            for(int i = 0; i<nodes[start].size(); i++) {
                int linkedNode = nodes[start].get(i);
                if(!visited[linkedNode] && dist + 1 <= K) {
                    visited[linkedNode] = true;
                    queue.add(new Integer[]{linkedNode, dist + 1});
                }
            }
        }

        if(cities.isEmpty()) {
            System.out.println(-1);
        } else {
            cities.sort(Comparator.naturalOrder());
            for (Integer city : cities) {
                System.out.println(city);
            }
        }
    }
}
