package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int apple_count = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i<apple_count; i++) {
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken())-1;
            int dy = Integer.parseInt(st.nextToken())-1;

            map[dx][dy] = 1;
        }
        int move_count = Integer.parseInt(br.readLine());

        String[][] move = new String[move_count][2];
        for(int i = 0; i<move_count; i++) {
            st = new StringTokenizer(br.readLine());
            move[i][0] = st.nextToken();
            move[i][1] = st.nextToken();
        }

        int[] dir = {0,1,2,3};
        // 0 오른쪽 1 아래 2 왼쪽 3 위
        int current_dir = 0;
        Deque<Integer[]> snake = new ArrayDeque<>();
        snake.add(new Integer[]{0,0});
        int start = 0;

        int count = 0;
        outer:
        for (int i = 0; i<=move.length; i++) {
            int left = 0;
            String turn = "";
            if(i == move.length) {
                left = 10000;
            } else {
                int straight = Integer.parseInt(move[i][0]);
                left = straight - start;

                start = straight;
                turn = move[i][1];
            }



            while (left-- > 0) {
                count++;
                Integer[] head = snake.getFirst();
                int dx = head[0];
                int dy = head[1];
                map[dx][dy] = -1;

                if (current_dir == 0) {
                    dy += 1;
                } else if (current_dir == 1) {
                    dx += 1;
                } else if (current_dir == 2) {
                    dy -= 1;
                } else {
                    dx -= 1;
                }

                Integer[] new_head = new Integer[]{dx, dy};
                if(dx < 0 || dx >= N || dy < 0 || dy >= N) {
                    break outer;
                }

                if (map[dx][dy] == 1) {
                    snake.addFirst(new_head);
                    map[dx][dy] = -1;
                } else {
                    if (map[dx][dy] == -1) break outer;
                    snake.addFirst(new_head);
                    map[dx][dy] = -1;
                    Integer[] a = snake.pollLast();
                    map[a[0]][a[1]] = 0;
                }

            }
            if (current_dir == 0) {
                if (turn.equals("L")) {
                    current_dir = 3;
                } else if (turn.equals("D")) {
                    current_dir = 1;
                }
            } else if (current_dir == 1) {
                if (turn.equals("L")) {
                    current_dir = 0;
                } else if (turn.equals("D")) {
                    current_dir = 2;
                }
            } else if (current_dir == 2) {
                if (turn.equals("L")) {
                    current_dir = 1;
                } else if (turn.equals("D")) {
                    current_dir = 3;
                }
            } else {
                if (turn.equals("L")) {
                    current_dir = 2;
                } else if (turn.equals("D")) {
                    current_dir = 0;
                }
            }

        }
        System.out.println(count);
    }
}
