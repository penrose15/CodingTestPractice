package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int N;
    static int M;
    static int val = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N / 2;

        arr = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 1);

        System.out.println(val);
    }

    static void backtracking(int x, int cnt) {
        if(cnt > M) {
            List<Integer> startTeam = new ArrayList<>();
            List<Integer> linkTeam = new ArrayList<>();
            for(int i = 0; i<N; i++) {
                // 스타트 팀과 그 외 팀간 시너지 합 구해야 함
                if(visited[i]) {
                    linkTeam.add(i);
                } else {
                    startTeam.add(i);
                }
            }
            int start = synergySum(startTeam);
            int link = synergySum(linkTeam);

            val = Math.min(val, Math.abs(start - link));
            return;
        }

        // 조합 구하기
        for(int i = x; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }

    // 각각 팀 시너지 총 합
    static int synergySum(List<Integer> team) {
        int sum = 0;
        for(int i = 0; i<team.size(); i++) {
            for(int j = i+1; j<team.size(); j++) {
                int a = team.get(i);
                int b = team.get(j);

                sum += arr[a][b];
                sum += arr[b][a];
            }
        }
        return sum;
    }
}
