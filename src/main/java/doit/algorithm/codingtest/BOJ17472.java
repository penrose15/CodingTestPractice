package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17472 {
    static int N;
    static int M;
    static int[][] map;
    static int[] parents;
    static PriorityQueue<Edge> graph;
    static int islandCnt = 0;
    static int[] xMove = new int[]{1, -1, 0, 0};
    static int[] yMove = new int[]{0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 좌표가 어디 섬에 해당하는지 임의의 번호를 할당한다
        getNodeMap();

        // 거리 측정 후 해당 좌표에 해당하는 노드를 구해 그래프에 넣는다.
        graph = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        getGraph();
        // 섬의 개수 만큼 parents 배열을 생성한다.
        parents = new int[islandCnt + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        // mst 실행
        int result = MST();

        for (int i = 1; i < parents.length - 1; i++) {
            if (find(parents[i]) != find(parents[i + 1])) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
    }

    static void getNodeMap() {
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j, num);
                    num += 1;
                    islandCnt += 1;
                }
            }
        }
    }

    static void BFS(int x, int y, int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        map[x][y] = num;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node xy = queue.poll();

            for (int i = 0; i < xMove.length; i++) {
                int tmpX = xy.x + xMove[i];
                int tmpY = xy.y + yMove[i];

                if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M) {
                    if (!visited[tmpX][tmpY] && map[tmpX][tmpY] == 1) {
                        visited[tmpX][tmpY] = true;
                        map[tmpX][tmpY] = num;
                        queue.add(new Node(tmpX, tmpY));
                    }
                }
            }
        }

    }

    static void getGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < xMove.length; k++) {
                        int tmpX = i + xMove[k];
                        int tmpY = j + yMove[k];
                        int cnt = 0;
                        while (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M &&
                                map[tmpX][tmpY] == 0) {
                            tmpX += xMove[k];
                            tmpY += yMove[k];
                            cnt += 1;
                        }
                        if (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M && cnt > 1) {
                            int start = map[i][j];
                            int end = map[tmpX][tmpY];

                            graph.add(new Edge(start, end, cnt));
                        }
                    }
                }
            }
        }
    }

    static int MST() {
        int cnt = 0;
        while (!graph.isEmpty()) {
            Edge edge = graph.poll();
            if (find(edge.s) != find(edge.e)) {
                cnt += edge.cost;
                union(edge.s, edge.e);
            }
        }
        return cnt;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parents[y] = x;
        else parents[x] = y;
    }

    static int find(int x) {
        if (parents[x] == x) return parents[x];
        else {
            parents[x] = find(parents[x]);
            return parents[x];
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
