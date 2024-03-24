package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int[][] map;
    static int N;
    static int M;
    static List<Integer[]> house = new LinkedList<>();
    static List<Integer[]> chicken = new LinkedList<>();
    static List<Integer[]> tmp_chicken = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<M; i++) {
            tmp_chicken.add(new Integer[]{});
        }

        map = new int[N][N];

        for(int i = 0; i<N; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] == 1) {
                    house.add(new Integer[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new Integer[]{i, j});
                }
            }
        }
        back_tracking(0,0);

        System.out.println(min1);

    }

    static int min1 = Integer.MAX_VALUE;
    public static void back_tracking(int count, int n) {
        if(count == M) {
            int a = 0;
            for(int i = 0; i<house.size(); i++) {
                int x = house.get(i)[0]; int y = house.get(i)[1];
                int min = Integer.MAX_VALUE;
                for(int j = 0; j<tmp_chicken.size(); j++) {
                    int tmpx = tmp_chicken.get(j)[0];
                    int tmpy = tmp_chicken.get(j)[1];
                    int result = Math.abs(tmpx -x) + Math.abs(tmpy - y);
                    if(result < min) {
                        min = result;
                    }
                }
                a += min;
            }
            min1 = Math.min(min1, a);
            return;
        }

        for(int i = n; i<chicken.size(); i++) {
            int x = chicken.get(i)[0];
            int y = chicken.get(i)[1];
            tmp_chicken.set(count, new Integer[]{x,y});

            back_tracking(count+1, i+1);
        }
    }
}
