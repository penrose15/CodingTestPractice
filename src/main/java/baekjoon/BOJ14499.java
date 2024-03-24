package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        command = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }
        Dice dice = new Dice();
        copy_number(dice, x, y);



    }

    public static void copy_number(Dice dice, int x, int y) {
        int tx = x; int ty = y;
        for(int i = 0; i<K; i++) {
            int dir = command[i];
            int[] m = move(dir);
            if(tx + m[0] < 0 || tx + m[0] >=N || ty + m[1] < 0 || ty + m[1] >=M) continue;
            tx += m[0]; ty += m[1];
            dice.move(dir);
            if(map[tx][ty] == 0) {
                map[tx][ty] = dice.dice[1][1];
                System.out.println(dice.ceil());
            } else {
                dice.dice[1][1] = map[tx][ty];
                System.out.println(dice.ceil());
                map[tx][ty] = 0;
            }


        }

    }
    public static int[] move(int dir) {
        if(dir == 1) {
            return new int[]{0,1};
        }
        if(dir == 2) {
            return new int[]{0,-1};
        }
        if(dir == 3) {
            return new int[]{-1,0};
        }
        else  {
            return new int[]{1,0};
        }
    }

    public static class Dice {
        int[][] dice = new int[4][3];
        int floor = 0;
        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        public void move(int dir) {
            if(dir == 1 && y < M) {
                int tmp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = tmp;
            }
            if(dir == 2 && y >= 0) {
                int tmp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = tmp;
            }
            if(dir == 3 && x >= 0) {
                int tmp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = tmp;
            }
            if(dir == 4 && x < N) {
                int tmp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = tmp;
            }
        }

        public int ceil() {
            return dice[3][1];
        }
    }
}
