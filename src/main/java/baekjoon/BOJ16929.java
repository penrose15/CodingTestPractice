package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16929 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] dots = new char[N][M];
        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j<M; j++) {
                dots[i][j] = str.charAt(j);
            }
        }
        boolean result = false;
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                dfs(dots, visited, i, j, i, j, 0);
                if(cycle) {
                    break;
                }
                visited = new boolean[N][M];
            }
        }
        if(cycle) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static boolean cycle = false;
    public static boolean dfs(char[][] dots, boolean[][] visited, int x, int y ,int startx, int starty,int count) {
        if(startx == x && starty == y && count>=4) {
            cycle = true;
            return true;
        }

        for(int i = 0; i<dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if(tx >= 0 && tx < N && ty >= 0 && ty <M) {
                if(dots[x][y] == dots[tx][ty]) {
                    if(!visited[tx][ty] ) {
                        visited[tx][ty] = true;
                        dfs(dots, visited, tx, ty, startx, starty,count + 1);
                        visited[tx][ty] = false;
                    }
                }
            }
        }
        return false;

    }
}
