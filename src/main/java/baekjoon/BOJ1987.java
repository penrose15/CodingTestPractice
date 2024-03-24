package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    static int R = 0;
    static int C = 0;

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        for(int i = 0; i<R; i++) {
            String str = br.readLine();
            for(int j = 0; j<C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        boolean[] alphabet = new boolean[26];
        alphabet[map[0][0] - 'A'] = true;
        dfs(map, alphabet, 0,0, count);
        System.out.println(max);
    }
    static int max = Integer.MIN_VALUE;
    static int count = 1;
    public static void dfs(char[][] map, boolean[] visited, int x, int y, int count) {
        char c = map[x][y];
        if(count > max) {
            max = count;
        }
        for(int i = 0; i<dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < R && ty >=0 && ty < C) {
                if(!visited[map[tx][ty] - 'A']) {
                    visited[map[tx][ty] - 'A'] = true;
                    dfs(map, visited, tx, ty, count+1);
                    visited[map[tx][ty] - 'A'] = false;

                }
            }
        }
    }
}
