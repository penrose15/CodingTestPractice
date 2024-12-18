package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686_2 {
    static int[][] map;
    static List<Integer[]> houses = new LinkedList<>();
    static List<Integer[]> chickens = new LinkedList<>();
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (n == 1) {
                    houses.add(new Integer[]{i, j});
                }
                if (n == 2) {
                    chickens.add(new Integer[]{i, j});
                }
            }
        }

        List<Integer[]> list = new LinkedList<>();
        getMinimumChickens(0, 0, list);

        System.out.println(min);
    }

    static void getMinimumChickens(int idx, int cnt, List<Integer[]> list) {
        if (cnt == M) {
            // list 기반으로 최소 거리 구하기
            getMinDist(list);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            list.add(chickens.get(i));
            getMinimumChickens(i + 1, cnt + 1, list);
            list.remove(list.size() - 1);
        }
    }

    static void getMinDist(List<Integer[]> list) {
        int dist = 0;
        for (int i = 0; i < houses.size(); i++) {
            Integer[] house = houses.get(i);
            dist += getMinDistToChicken(list, house);
        }

        if (min > dist) {
            min = dist;
        }
    }

    static int getMinDistToChicken(List<Integer[]> list, Integer[] house) {
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer[] chicken = list.get(i);
            int hToC = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
            dist = Math.min(dist, hToC);
        }
        return dist;
    }
}
