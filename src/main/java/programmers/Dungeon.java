package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dungeon {
    static int  count = 0;
    static List<Integer> list = new ArrayList<>();
    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons,k, 0, visited, 0, dungeons.length, 0);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    public  static void dfs(int[][] dungeons, int k,int i,boolean[] visited, int depth,int r, int cnt) {

        for(int j = 0; j < dungeons.length; j++) {
            if(!visited[j] && k >= dungeons[j][0]) {
                visited[j] = true;

                k -= dungeons[j][1];
                cnt = count;
                count++;
                dfs(dungeons, k, j, visited, depth+1, dungeons.length, cnt);
                visited[j] = false;
//                k+= dungeons[j][1];
            }
        }
        list.add(count);
    }

    public static void main(String[] args) {
        int[][] arr = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80, arr));
    }
}
