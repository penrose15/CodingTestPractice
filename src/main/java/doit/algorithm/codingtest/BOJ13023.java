package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int N, M;
    static int ANS = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            int depth = 1;
            dfs(i, depth);
            if(ANS == 1) break;
        }

        System.out.println(ANS);
    }

    public static void dfs(int start, int depth) {
        if (depth == 5 || ANS == 1) {
            ANS = 1;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < arr[start].size(); i++) {
            int linkedNumber = arr[start].get(i);
            if (!visited[linkedNumber]) {
                dfs(linkedNumber, depth + 1);
            }
        }
        visited[start] = false;
    }
}
