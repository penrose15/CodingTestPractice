package programmers;

public class 배달 {
    public static int solution(int N, int[][] road, int K) {
        int[][] map = new int[N+1][N+1];
        for(int i = 0; i<road.length; i++) {
            int[] arr = road[i];
            int start = arr[0];
            int end = arr[1];
            int length = arr[2];

            if(map[start][end] != 0) {
                length = Math.min(map[start][end], length);
            }
            if(map[end][start] != 0) {
                length = Math.min(map[start][end], length);
            }

            map[start][end] = length;
            map[end][start] = length;
        }
        boolean[] visited = new boolean[N+1];
        boolean[] dist = new boolean[N+1];

        dfs(map, dist,K, 1,  visited);
        return count;
    }
    static int count = 1;
    public static void dfs(int[][] map, boolean[] dist, int K, int start, boolean[] visited) {


        for(int i = 0; i<map.length; i++) {
            if(map[start][i] != 0
                    && !visited[start]) {
                visited[start] = true;
                dist[i]  = true;
                count++;
                dfs(map, dist, K, i, visited);
                visited[start] = false;

            }
        }
    }

    public static void main(String[] args) {
        int[][] road = new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int n = solution(6, road, 4);
        System.out.println(n);
    }
}
