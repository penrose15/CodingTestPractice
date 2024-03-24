package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<2; j++) {
                lectures[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1]- o2[1];
            } return o1[0] - o2[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(lectures[0][1]);
        //배정이 되지 않은 강의의 시작 시각과 우선 순위 큐 안에서 종료 시각이 가장 빠른 강의의 종료시간과 비교
        for(int i = 1; i< N; i++) {
            if(queue.peek() <= lectures[i][0]) {
                //만약 배정이 된 강의의 시작시간이 우선순위 큐의 종료 시각이 가장 빠른 강의의 종료 시각보다 늦다면 우선순위 큐 안의 가장 앞의 강의를 제거하고 현 강의를 큐에 넣는다
                queue.poll();
            }
            //아닌 경우 top에 있는 강의는 냅두고 우선순위 큐에 강의를 넣는다.
            queue.add(lectures[i][1]);
        }

        System.out.println(queue.size());

    }
}
