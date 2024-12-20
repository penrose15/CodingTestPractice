package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499_2 {
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[][] map;
    static int[] move;
    static int[] xMove = new int[]{0, 0, -1, 1};
    static int[] yMove = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        move = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            move[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        /*
         * 초기 상태는 1이 위, 6이 아래이다.
         * 이동 시 마다 위/아래의 숫자를 변경, (주사위가 회전은 안하니깐 아마 경우의 수 노가다로 하면 될 듯...?)
         *
         *
         * */
        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            int dir = move[i];
            boolean canMove = validateMove(x, y, dir);
            if (!canMove) continue;
            movePoint(dir);
            if (dir == 0) {
                dice.goEast();
            } else if (dir == 1) {
                dice.goWest();
            } else if (dir == 2) {
                dice.goNorth();
            } else if (dir == 3) {
                dice.goSouth();
            }
            dice = changeNumber(dice);
            System.out.println(dice.top);
        }
    }

    static boolean validateMove(int X, int Y, int dir) {
        if (X + xMove[dir] < 0 || X + xMove[dir] >= N) {
            return false;
        }
        if (Y + yMove[dir] < 0 || Y + yMove[dir] >= M) {
            return false;
        }
        return true;
    }

    static void movePoint(int dir) {
        x += xMove[dir];
        y += yMove[dir];
    }

    static Dice changeNumber(Dice dice) {
        if (map[x][y] != 0) {
            dice.bottom = map[x][y];
            map[x][y] = 0;
        } else {
            map[x][y] = dice.bottom;
        }
        return dice;
    }

    static class Dice {
        int front;
        int back;
        int left;
        int right;
        int top;
        int bottom;

        public Dice() {
            this.front = 0;
            this.back = 0;
            this.left = 0;
            this.right = 0;
            this.top = 0;
            this.bottom = 0;
        }

        public void goEast() {
            int tmp = this.bottom;
            this.bottom = this.right;
            this.right = this.top;
            this.top = this.left;
            this.left = tmp;
        }

        public void goWest() {
            int tmp = this.top;
            this.top = this.right;
            this.right = this.bottom;
            this.bottom = this.left;
            this.left = tmp;
        }

        public void goNorth() {
            int tmp = this.top;
            this.top = this.back;
            this.back = this.bottom;
            this.bottom = this.front;
            this.front = tmp;
        }

        public void goSouth() {
            int tmp = this.bottom;
            this.bottom = this.back;
            this.back = this.top;
            this.top = this.front;
            this.front = tmp;
        }
    }
}
