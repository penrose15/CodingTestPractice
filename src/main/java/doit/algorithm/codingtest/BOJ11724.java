package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N, M, CNT = 0;
    static boolean[] visited;
    static int[][] nodes;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();
        N = Integer.parseInt(NM.split(" ")[0]);
        M = Integer.parseInt(NM.split(" ")[1]);

        nodes = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<M; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[s][e] = 1;
            nodes[e][s] = 1;
        }

        for(int i = 1; i<= N; i++) {
            if(!visited[i]) {
                CNT++;
                DFS(i);
            }
        }

        System.out.println(CNT);
    }

    static void DFS(int start) {
        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int nodeIndex = stack.pop();
            for(int i = 1; i<nodes[nodeIndex].length; i++) {
                int linkedNode = nodes[nodeIndex][i];
                if(linkedNode == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}
