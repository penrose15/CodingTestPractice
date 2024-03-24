package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2667 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] maps = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i<N; i++) {
            String tmp = br.readLine();
            String[] arr = tmp.split("");
            for(int j = 0; j<arr.length; j++) {
                maps[i][j] = Integer.parseInt(arr[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(maps[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, maps, visited);
                    if(count > 0) {
                        list.add(count);
                    }
                    count = 0;
                }
            }
        }
        System.out.println(list.size());
        list.sort(Comparator.naturalOrder());
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static void dfs(int x, int y, int[][] maps, boolean[][] visited) {
        visited[x][y] = true;
        count++;
        for(int i = 0; i<dx.length; i++) {
            if(x + dx[i] < maps.length && y + dy[i] < maps.length && x + dx[i] >= 0 && y + dy[i] >= 0) {
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];
                if(maps[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]) {
                    dfs(tmpX, tmpY, maps, visited);
                }
            }
        }
    }
}
