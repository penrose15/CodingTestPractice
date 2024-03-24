package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리_2트 {

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int count = 0;

    public static class Player {
        int x;
        int y;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(maps, visited, 0,0);
        return count;
    }

    public static void bfs(int[][] maps, boolean[][] visited, int x, int y) {
        Queue<Player> queue = new LinkedList<>();
        Player player = new Player(x, y);
        queue.offer(player);
        visited[x][y] = true;
        int[][] walk = new int[maps.length][maps[0].length];

        while (!queue.isEmpty()) {
            Player q = queue.peek();
            if(q.x == maps.length-1 && q.y == maps[0].length-1) {
                break;
            }
            Player p = queue.poll();

            for(int i = 0; i<dx.length; i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                if(tx >= 0 && tx < maps.length && ty >= 0 && ty < maps[0].length&&!visited[tx][ty] && maps[tx][ty] == 1) {
                    walk[tx][ty] = walk[p.x][p.y] + 1;
                    visited[tx][ty] = true;
                    queue.offer(new Player(tx, ty));
                }
            }
        }

        if(queue.isEmpty()) {
            count = -1;
        } else {
            for (int i = 0; i< walk.length; i++) {
                System.out.println(Arrays.toString(walk[i]));
            }
            count = walk[maps.length-1][maps[0].length-1] + 1;
        }
    }

    public static void main(String[] args) {
        int[][] maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
