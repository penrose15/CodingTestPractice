package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(temp.nextToken());
        int M = Integer.parseInt(temp.nextToken());

        int[][] maps = new int[N][M];

        for(int i = 0; i< maps.length; i++) {
            String tmp = br.readLine();
            String[] arr = tmp.split("");
            for (int j = 0; j< arr.length; j++) {
                maps[i][j] = Integer.parseInt(arr[j]);
            }
        }
        int x = 0; int y = 0;

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> list = List.of(x,y);
        queue.add(list);

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            List<Integer> list1 = queue.poll();
            x = list1.get(0);
            y = list1.get(1);

            if(x == N-1 && y == M-1) {
                answer = maps[x][y];
            }
            for(int i = 0; i< dx.length; i++) {
                int tmpx = x + dx[i];
                int tmpy = y + dy[i];

                if(tmpx >= 0 && tmpx < N && tmpy >= 0 && tmpy < M) {
                    if(maps[tmpx][tmpy] == 1) {
                        if(!visited[tmpx][tmpy]) {
                            List<Integer> list2 = List.of(tmpx, tmpy);
                            queue.add(list2);
                            maps[tmpx][tmpy] = maps[x][y] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
