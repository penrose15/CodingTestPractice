package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

* */

public class BOJ1167 {
    static int N;
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    static int[] distArr;
    static long maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];

        for(int i = 1; i<N+1; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 1; i<N+1; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            int start = Integer.parseInt(st.nextToken());

            while(st.hasMoreElements()) {
                int number = Integer.parseInt(st.nextToken());
                if(number != -1) {
                    int distance = Integer.parseInt(st.nextToken());
                    int[] arr1 = new int[]{number, distance};

                    tree[start].add(arr1);
                } else {
                    break;
                }
            }
        }
        visited = new boolean[N+1];
        distArr = new int[N+1];

        int next = bfs(1);
        Arrays.fill(visited, false);
        Arrays.fill(distArr, 0);
        bfs(next);


        System.out.println(maxDist);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 0; i<tree[node].size(); i++) {
                int[] arr = tree[node].get(i);
                int linkedNode = arr[0];
                int dist = arr[1];

                if(!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    queue.add(linkedNode);
                    distArr[linkedNode] = dist + distArr[node];
                }
            }
        }

        int tmp = 0;
        for(int i = 1; i<distArr.length; i++) {
            if(maxDist < distArr[i]) {
                maxDist = distArr[i];
                tmp = i;
            }
        }
        return tmp;

    }
}
