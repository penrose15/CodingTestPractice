package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = new int[]{1,0,-1,0};
    static int[] moveY = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++) {
            String line = br.readLine();
            String[] numbers = line.split("");
            for(int j = 0; j<numbers.length; j++) {
                int a = Integer.parseInt(numbers[j]);
                map[i][j] = a;
            }
        }
        visited[0][0] = true;
        searchPath(0, 0);
    }

    static void searchPath(int startX, int startY) {
        int cnt = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, cnt));

        while (!queue.isEmpty()) {
            Point start = queue.poll();

            if(start.getX() == N-1 && start.getY() == M-1) {
                System.out.println(start.getCnt());
                return;
            }

            for(int i = 0; i<moveX.length; i++) {
                int endX = start.getX() + moveX[i];
                int endY = start.getY() + moveY[i];
                int endCnt = start.getCnt();

                if(endX >= 0 && endX <= N-1 && endY >= 0 && endY <= M-1) {
                    if(map[endX][endY] == 1 && !visited[endX][endY]) {
                        visited[endX][endY] = true;
                        endCnt += 1;
                        queue.add(new Point(endX, endY, endCnt));
                    }
                }
            }
        }

    }

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
