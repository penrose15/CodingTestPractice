package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[][] map;
    static int[][] room;
    static List<Integer[]> zero = new LinkedList<>();
    static List<Integer[]> list = new LinkedList<>();
    static Queue<Integer[]> queue = new LinkedList<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        visited = new boolean[N][M];
        room = new int[N][M];

        zero.add(new Integer[]{});
        zero.add(new Integer[]{});
        zero.add(new Integer[]{});

        list = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == 2) {
                    queue.add(new Integer[]{i, j});
                }
                if(room[i][j] == 0) {
                    list.add(new Integer[]{i, j});
                }
            }
        }

        map = new int[N][M];
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                map[i][j] = room[i][j];
            }
        }

        backtracking(0,0);
        System.out.println(max);


    }
    static int max = Integer.MIN_VALUE;
    public static void backtracking(int n, int c) {
        if(c == 3) {
            for(int i = 0; i<3; i++) {
                Integer[] arr = zero.get(i);
                int x = arr[0]; int y = arr[1];
                map[x][y] = 1;
            }

            //2 번식시킴 BFS
            bfs(queue, visited);

            int count = 0;
            for(int i = 0; i<map.length; i++) {
                for(int j = 0; j<map[0].length; j++) {
                    if(map[i][j] == 0) {
                        count++;
                    }
                }
            }
            max = Math.max(count, max);

            visited = new boolean[visited.length][visited[0].length];
            for(int i = 0; i< visited.length; i++) {
                for(int j = 0; j< visited[0].length; j++) {
                    map[i][j] = room[i][j];
                }
            }
            queue.clear();
            for(int i = 0; i<room.length; i++) {
                for(int j = 0; j<room[0].length; j++) {
                    if(room[i][j] == 2) {
                        queue.add(new Integer[]{i, j});
                    }
                }
            }


            return;
        }

        for(int i = n; i< list.size(); i++) {
            Integer[] arr = list.get(i);
            int tmpx = arr[0]; int tmpy = arr[1];
            zero.set(c, new Integer[]{tmpx, tmpy});

            backtracking(i+1, c+1);
        }
    }

    public static void bfs(Queue<Integer[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            Integer[] arr = queue.poll();
            int x = arr[0]; int y = arr[1];

            for(int i = 0; i<dx.length; i++) {
                int tx = x + dx[i]; int ty = y + dy[i];
                if(tx >= 0 && tx < visited.length && ty >= 0 && ty < visited[0].length) {
                    if(!visited[tx][ty]) {
                        if(map[tx][ty] == 0) {
                            visited[tx][ty] = true;
                            map[tx][ty] = 2;
                            queue.add(new Integer[]{tx, ty});
                        }
                    }
                }
            }
        }
    }
}
