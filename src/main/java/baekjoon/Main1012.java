package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012 {
    static int[][] field;
    static int count = 0;

    static int x;
    static int y;
    static int cabbages;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());



        StringTokenizer st;
        for(int i = 0; i<testcase; i++) {
            count = 0;

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cabbages = Integer.parseInt(st.nextToken());

            field = new int[x][y];
            boolean[][] visited = new boolean[x][y];
            for(int cabbage = 1; cabbage <= cabbages; cabbage++) {
                st = new StringTokenizer(br.readLine());

                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());

                field[cx][cy] = 1;
            }

            for(int ix = 0; ix < x; ix++) {
                for(int iy = 0; iy < y; iy++) {
                    if(field[ix][iy] == 1 && !visited[ix][iy]) {
                        dfs(ix, iy, visited);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int ix, int iy, boolean[][] visited) {
        if(field[ix][iy] == 0) return;
        visited[ix][iy] = true;

        for(int i = 0; i<4; i++) {
            if(ix + dx[i] < 0 || ix + dx[i] >= x || iy + dy[i] <0 || iy + dy[i] >= y) continue;
            if(!visited[ix + dx[i]][iy + dy[i]] && field[ix+dx[i]][iy+dy[i]] == 1) {
                dfs(ix+dx[i],iy+dy[i], visited);
            }


        }
    }

}
