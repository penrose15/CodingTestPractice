package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N;
    static int M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); //0 북 1 동 2 남 3 서

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            if(room[r][c] == 0) {
                room[r][c] = -1;
            }

            boolean dirt = true;
            for(int i = 0; i<dx.length; i++) {
                int tr = r + dx[i];
                int tc = c + dy[i];
                if(tr < 0 || tr >= N || tc < 0 || tc >= M) {
                    continue;
                }
                if(room[tr][tc] == 0) {
                    dirt = false;
                    break;
                }
            }

            if(dirt) {
                int reverse = goBack(d);
                int tr = r + dx[reverse]; int tc = c + dy[reverse];
                if(tr < 0 || tr >= N || tc < 0 || tc > M) break;
                if(room[tr][tc] == 1) break;
                if(room[tr][tc] != 1) {
                    r = tr; c = tc;
                }
            }
            else {
                do {
                    d -= 1;
                    if(d < 0) d = 3;
                    if(r + dx[d] < 0 || r + dx[d] >= N || c + dy[d] < 0 || c + dy[d]  >= M) {
                        continue;
                    }
                } while (room[r + dx[d]][c + dy[d]] != 0);

                r += dx[d]; c += dy[d];
                room[r][c] = -1;
            }
        }
        int cnt = 0;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(room[i][j] == -1) cnt+=1;
            }
        }
        System.out.println(cnt);
    }

    public static int goBack(int d) {
        if(d == 0) return 2;
        if(d == 1) return 3;
        if(d == 2) return 0;
        return 1;
    }
}
