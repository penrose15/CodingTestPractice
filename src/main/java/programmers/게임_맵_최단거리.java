package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 게임_맵_최단거리 {

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int answer = -1;
    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(0,0,maps, visited);

        return answer;
    }

    public static void bfs(int x, int y, int[][] maps, boolean[][] visited) {
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> list = List.of(x, y);

        q.add(list);
        visited[x][y] = true;
        while (!q.isEmpty() ) {
            List<Integer> list1 = q.poll();
            x = list1.get(0);
            y = list1.get(1);

            if(x == maps.length-1 && y == maps[0].length-1) {
                answer = maps[x][y];
            }

            for(int i = 0; i< dx.length; i++) {
                int tmpx = x + dx[i];
                int tmpy = y + dy[i];

                if(tmpx >= 0 && tmpx < maps.length && tmpy >= 0 && tmpy < maps[0].length && maps[tmpx][tmpy] == 1) {
                    if(!visited[tmpx][tmpy]) {

                        q.add(List.of(tmpx, tmpy));
                        visited[tmpx][tmpy] = true;
                        maps[tmpx][tmpy] = maps[x][y]+1;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(map));
    }
}
