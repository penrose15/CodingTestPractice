package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325 {
    static int N;
    static int M;
    static ArrayList<Integer>[] computers;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            computers[s].add(e);
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int computer = queue.poll();

                for (int j = 0; j < computers[computer].size(); j++) {
                    int linkedComputer = computers[computer].get(j);
                    if (!visited[linkedComputer]) {
                        visited[linkedComputer] = true;
                        answer[linkedComputer]++;
                        queue.add(linkedComputer);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i < answer.length; i++) {
            max = Math.max(max, answer[i]);
        }

        for (int i = 1; i < answer.length; i++) {
            if (max == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
