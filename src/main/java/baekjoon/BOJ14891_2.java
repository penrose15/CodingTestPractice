package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14891_2 {
    static int[][] gears = new int[4][8];
    static int K;
    static int[][] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Integer.parseInt(str[j]);
            }
        }

        K = Integer.parseInt(br.readLine());
        move = new int[K][2];
        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            move[i][0] = Integer.parseInt(str[0]);
            move[i][1] = Integer.parseInt(str[1]);
        }

        for (int i = 0; i < K; i++) {
            int gear = move[i][0] - 1;
            int dir = move[i][1];

            int gearTwo = gears[gear][2];
            int gearSix = gears[gear][6];
            gear(gear, dir);

            if (gear > 0 && gear < 3) {
                int tmpDir = dir;
                for (int j = gear + 1; j <= 3; j++) {
                    if (gearTwo == gears[j][6]) {
                        break;
                    }
                    gearTwo = gears[j][2];
                    tmpDir = changeDir(tmpDir);
                    gear(j, tmpDir);
                }
                tmpDir = dir;
                for (int j = gear - 1; j >= 0; j--) {
                    if (gearSix == gears[j][2]) {
                        break;
                    }
                    gearSix = gears[j][6];
                    tmpDir = changeDir(tmpDir);
                    gear(j, tmpDir);
                }
            } else if (gear == 0) {
                int tmpDir = dir;
                for (int j = gear + 1; j <= 3; j++) {
                    if (gearTwo == gears[j][6]) {
                        break;
                    }
                    gearTwo = gears[j][2];
                    tmpDir = changeDir(tmpDir);
                    gear(j, tmpDir);
                }
            } else if (gear == 3) {
                int tmpDir = dir;
                for (int j = gear - 1; j >= 0; j--) {
                    if (gearSix == gears[j][2]) {
                        break;
                    }
                    gearSix = gears[j][6];
                    tmpDir = changeDir(tmpDir);
                    gear(j, tmpDir);
                }
            }
        }

        int result = sum();
        System.out.println(result);
    }


    static int changeDir(int dir) {
        if (dir == -1) return 1;
        return -1;
    }
    // 1 2 3 4 5 6 -> 1 1 2 3 4 5
    // 1 2 3 4 5 6 -> 2 3 4 5 6 6

    static void gear(int gear, int dir) {
        if (dir == 1) {
            int end = gears[gear][7];
            for (int i = 7; i > 0; i--) {
                gears[gear][i] = gears[gear][i - 1];
            }
            gears[gear][0] = end;
        }
        if (dir == -1) {
            int start = gears[gear][0];
            for (int i = 0; i < 7; i++) {
                gears[gear][i] = gears[gear][i + 1];
            }
            gears[gear][7] = start;
        }
    }

    static int sum() {
        return gears[0][0] + gears[1][0] * 2 + gears[2][0] * 4 + gears[3][0] * 8;
    }
}
