package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int F = Integer.parseInt(arr[0]); //건물 층수
        int S = Integer.parseInt(arr[1]); //현재 위치
        int G = Integer.parseInt(arr[2]); //스타트링크 위치
        int U = Integer.parseInt(arr[3]); //위로가는 버튼
        int D = Integer.parseInt(arr[4]); //아래로 가는 버튼

        int[] building = new int[F+1];
        Arrays.fill(building, Integer.MAX_VALUE);
        building[S] = 0;
        boolean[] visited = new boolean[F+1];
        int[] upOrDown = new int[]{U, - D};
        bfs(building, visited, S, G, upOrDown);

        if(building[G]+1 >= 0 && building[G]<Integer.MAX_VALUE) {
            System.out.println(building[G]);
        } else {
            System.out.println("use the stairs");
        }



    }
    static int count = 0;
    public static void bfs(int[] building, boolean[] visited, int start, int end, int[] upOrDown) {
        int limit = building.length-1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            start = queue.poll();
            count++;
            if(start == end) break;

            if(!visited[start]) {
                visited[start] = true;
                for (int j : upOrDown) {
                    int floor = start + j;
                    if (floor > limit) {
                        continue;
                    } else if (floor < 1) {
                        continue;
                    }
                    if(building[start + j] >= building[start] + 1) {
                        building[floor] = Math.min(building[start] + 1, building[floor]);
                        if (floor == end) break;
                        queue.add(floor);
                    }
                }
            }
        }
    }
}
