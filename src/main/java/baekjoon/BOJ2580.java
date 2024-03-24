package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        boolean[][][] visited = new boolean[9][9][9];
        int count = 0;
        List<Point> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0) {
                    list.add(new Point(i, j));
                    count++;
                }
            }
        }
        backTracking(sudoku, visited,count, list, 0);
    }

    static int total = 0;
    public static void backTracking(int[][] sudoku, boolean[][][] visited,int count, List<Point> list, int k) {
        if(count <= 0) {
            if(total >= 9) {
                return;
            }
            for(int i = 0; i<sudoku.length; i++) {
                total++;
                System.out.println(Arrays.toString(sudoku[i]).replaceAll("\\[","").replaceAll("\\]","").replaceAll(",",""));

            }
            System.out.println();
            return;
        }

        int x = list.get(k).x;
        int y = list.get(k).y;

        if(sudoku[x][y] == 0) {
            int result = -1;
            outer:
            for(int i = 1; i<=9; i++) {
                int number = i;
                if(visited[x][y][number-1]) {
                    continue;
                }
                for(int j = 0; j<9; j++) {
                    if(sudoku[x][j] == number) {
                        continue outer;
                    }
                }
                for(int j = 0; j<9;j++) {
                    if(sudoku[j][y] == number) {
                        continue outer;
                    }
                }
                int dx = x/3; int dy = y/3;
                for(int j = dx*3; j<(dx+1)*3;j++) {
                    for(int l = dy*3; l<(dy+1)*3;l++) {
                        if(sudoku[j][l] == number) {
                            continue outer;
                        }
                    }
                }
                sudoku[x][y] = number;
                for(int j = 0; j<9; j++) {
                    visited[x][j][number-1] = true;
                    visited[j][y][number-1] = true;
                }
                backTracking(sudoku, visited,count-1, list, k+1);
                for(int j = 0; j<9; j++) {
                    visited[x][j][number-1] = false;
                    visited[j][y][number-1] = false;
                }
                sudoku[x][y] = 0;

            }

        }

    }

}
