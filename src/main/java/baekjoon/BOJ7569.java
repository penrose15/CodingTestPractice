package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7569 {

    public static class xyz{
        int x = 0;
        int y = 0;
        int z = 0;

        public xyz(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] dx = new int[]{1,-1,0,0,0,0};
    static int[] dy = new int[]{0,0,1,-1,0,0};
    static int[] dz = new int[]{0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        int H = Integer.parseInt(str[2]);

        int[][][] tomato = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];

        for(int i = 0; i<H; i++) {
            for(int j = 0; j<N; j++) {
                String[] s = br.readLine().split(" ");
                for(int k = 0; k<M; k++) {
                    tomato[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }
        Queue<xyz> queue = new LinkedList<>();

        for(int i = 0; i<H; i++) {
            for(int j = 0; j<N; j++) {
                for(int k = 0; k<M; k++) {
                    if(tomato[i][j][k] == 1) {
                        queue.add(new xyz(k,j,i));

                    }
                }
            }
        }

        int[][][] c = new int[H][N][M];
        while (!queue.isEmpty()) {
            xyz xyz1 = queue.poll();
            if(tomato[xyz1.z][xyz1.y][xyz1.x] == 1 && !visited[xyz1.z][xyz1.y][xyz1.x]) {

                visited[xyz1.z][xyz1.y][xyz1.x] = true;
                int x = xyz1.x; int y = xyz1.y; int z = xyz1.z;
                for(int l = 0; l<dx.length; l++) {
                    xyz1.x = x + dx[l];
                    xyz1.y = y + dy[l];
                    xyz1.z = z + dz[l];
                    if(!(xyz1.x < 0 || xyz1.x >= M || xyz1.y < 0 || xyz1.y >= N || xyz1.z <0 || xyz1.z >=H) && tomato[xyz1.z][xyz1.y][xyz1.x] == 0) {
                        tomato[xyz1.z][xyz1.y][xyz1.x] = 1;
                        c[xyz1.z][xyz1.y][xyz1.x] = c[z][y][x] + 1;
                        queue.add(new xyz(xyz1.x, xyz1.y,xyz1.z));
                    }
                }
            }

        }
        int zero = 0;
        outer :
        for(int i = 0; i<H; i++) {
            for(int j = 0; j<N; j++) {
                for(int k = 0; k<M; k++) {
                    if(tomato[i][j][k] == 0) {
                        zero ++;
                        break outer;
                    }
                }
            }
        }
        if(zero > 0) System.out.println(-1);

        else {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<H; i++) {
                for(int j = 0; j<N; j++) {
                    for(int k = 0; k<M; k++) {
                        if(max < c[i][j][k]) {
                            max = c[i][j][k];
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }



}
