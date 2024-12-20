package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2615 {
    static int[][] baduk = new int[19][19];
    static int[][][] memo = new int[19][19][4];
    static int win = 0;
    static int[] xMove = new int[]{0, 1, 1, -1};
    static int[] yMove = new int[]{1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                baduk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (baduk[i][j] != 0) {
                    for (int idx = 0; idx < xMove.length; idx++) {
                        if (memo[i][j][idx] == 0) {
                            int ax = i;
                            int ay = j;

                            memo[i][j][idx] = baduk[i][j];
                            dfs(i, j, 0, idx, baduk[i][j], i, j);
                            if (win != 0) {
                                int rx = ax + 1;
                                int ry = ay + 1;
                                System.out.println(win);
                                System.out.println(rx + " " + ry);
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (win == 0) {
            System.out.println(0);
        }

    }

    static void dfs(int x, int y, int cnt, int idx, int num, int topX, int topY) {
        // 만약 cnt == 5 인 경우
        // 다음이 있는지 확인 -> 있으면 리턴
        // 없으면 num, x + 1, y + 1 출력 후 리턴
        if (cnt == 4) {
            int tmpX = x + xMove[idx];
            int tmpY = y + yMove[idx];
            if (tmpX >= 0 && tmpX < 19 && tmpY >= 0 && tmpY < 19) {
                if (baduk[tmpX][tmpY] == num) {
                    memo[tmpX][tmpY][idx] = num;
                    return;
                }
            }
            win = num;
        }

        int tmpX = x + xMove[idx];
        int tmpY = y + yMove[idx];
        if (tmpX >= 0 && tmpX < 19 && tmpY >= 0 && tmpY < 19) {
            if (baduk[tmpX][tmpY] == num) {
                memo[tmpX][tmpY][idx] = num;
                dfs(tmpX, tmpY, cnt + 1, idx, num, topX, topY);
            }
        }

    }
}
