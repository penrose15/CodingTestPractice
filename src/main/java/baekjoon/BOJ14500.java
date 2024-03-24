package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N;
    static int M;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {

                visited[i][j] = true;
                dfs(square, i, j, visited, 1, square[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.print(max);

    }
    static int max = Integer.MIN_VALUE;
    public static void dfs(int[][] square ,int x, int y, boolean[][] visited,int count, int sum) {
        if(count == 4) {
            if(max < sum) {
                max = sum;
            }
            return;
        }

        for(int i = 0; i<dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx >= 0 && tx < N && ty >= 0 && ty < M) {
                if (!visited[tx][ty]) {
                    if(count == 2) {
                        visited[tx][ty] = true;
                        dfs(square, x, y, visited, count + 1, sum + square[tx][ty]);
                        visited[tx][ty] = false;
                    }
                    visited[tx][ty] = true;
                    dfs(square, tx, ty, visited, count + 1, sum + square[tx][ty]);
                    visited[tx][ty] = false;
                }
            }
        }
    }
}
