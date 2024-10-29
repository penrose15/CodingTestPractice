package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2251 {
    static int A;
    static int B;
    static int C;
    static int[] sender = new int[]{0, 0, 1, 1, 2, 2};
    static int[] receiver = new int[]{1, 2, 0, 2, 0, 1};
    static boolean[][] visited = new boolean[201][201];
    static boolean[] answer = new boolean[201];
    static int[] now = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());

        bfs();

        for(int i = 0; i<answer.length; i++) {
            if(answer[i]) {
                System.out.print(i + " ");
            }
        }

    }

    static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0,0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while(!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;
            for(int i = 0; i<6; i++) {
                int[] next = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                if(next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
