package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11559 {
    public static char[][] puyo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        puyo = new char[12][6];

        for(int i = 0; i<12; i++) {
            String str = br.readLine();
            for(int j = 0; j<6; j++) {
                puyo[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        while(true) {
            List<Integer[]> totalList = new ArrayList<>();
            for(int i = 0; i<12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (puyo[i][j] != '.' && puyo[i][j] != ' ') {
                        list = new ArrayList<>();
                        bfs_puyo(i, j, puyo);
                        if (list.size() >= 4) {
                            for (Integer[] arr : list) {
                                int x = arr[0];
                                int y = arr[1];
                                puyo[x][y] = ' ';
                                totalList.add(new Integer[]{x, y});
                            }
                        }
                    }
                }
            }
            for(Integer[] arr : totalList) {
                int x = arr[0];
                int y = arr[1];
                for(int k = x; k>0; k--) {
                    puyo[k][y] = puyo[k-1][y];
                }
                puyo[0][y] = '.';
            }
            if(totalList.size() > 0) {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);

    }
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static List<Integer[]> list = new ArrayList<>();

    public static void bfs_puyo(int x, int y, char[][] puyo) {
        Queue<Integer[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[12][6];
        char p = puyo[x][y];
        queue.add(new Integer[]{x, y});

        list.add(new Integer[]{x, y});
        visited[x][y] = true;


        while (!queue.isEmpty()) {

            Integer[] arr = queue.poll();

            int x1 = arr[0];
            int y1 = arr[1];

            for(int i = 0; i<dx.length; i++) {
                int tx = x1 + dx[i];
                int ty = y1 + dy[i];

                if(tx >= 0 && tx < puyo.length && ty >=0 && ty < puyo[0].length) {
                    if(!visited[tx][ty]) {
                        if(puyo[tx][ty] == p) {
                            visited[tx][ty] = true;
                            list.add(new Integer[]{tx, ty});
                            queue.add(new Integer[]{tx, ty});
                        }
                    }
                }
            }



        }
    }
}
