package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] normal_grid = new char[n][n];

        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            char[] chars = str.toCharArray();
            normal_grid[i] = chars;
        }
        char[][] color_weakness_grid = new char[n][n];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(normal_grid[i][j] == 'G' || normal_grid[i][j] == 'R') {
                    color_weakness_grid[i][j] = 'R';
                } else {
                    color_weakness_grid[i][j] = normal_grid[i][j];
                }
            }
        }


        int normal_count = 0;
        boolean[][] normal_visited = new boolean[n][n];
        char now = normal_grid[0][0];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(!normal_visited[i][j]) {
                    normal(normal_grid, normal_visited, i, j, normal_grid[i][j]);
                    normal_count++;
                }
            }
        }
        int color_weakness_count = 0;
        boolean[][] color_weakness_visited = new boolean[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(!color_weakness_visited[i][j]) {
                    normal(color_weakness_grid, color_weakness_visited, i, j, color_weakness_grid[i][j]);
                    color_weakness_count++;
                }
            }
        }

        System.out.println(normal_count + " "+ color_weakness_count);
    }
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    public static void normal(char[][] grid, boolean[][] visited, int x, int y, char color) {

        for(int i = 0; i<dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < grid.length && ty >=0 && ty < grid.length) {
                if(grid[tx][ty] == color && !visited[tx][ty]) {
                    visited[tx][ty] = true;
                    normal(grid, visited, tx, ty, color);
                }
            }
        }
    }

}
