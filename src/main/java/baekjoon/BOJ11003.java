package baekjoon;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int endIdx = 0;

        List<Integer> list = new ArrayList<>();

        Deque<Point> deque = new ArrayDeque<>();
        int min = 0;
        while (endIdx < N) {
            if(endIdx == 0) {
                deque.add(new Point(endIdx, A[endIdx]));
            } else {
                Point firstP = deque.getFirst();
                if(endIdx - firstP.getIdx() == L) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && deque.getLast().getNumber() > A[endIdx]) {
                    deque.removeLast();
                }
                deque.addLast(new Point(endIdx, A[endIdx]));
            }
            Point p = deque.getFirst();
            list.add(p.getNumber());
            endIdx += 1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<list.size(); i++) {
            if(i > 0) result.append(" ");
            result.append(list.get(i));
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    static class Point {
        int idx;
        int number;

        public Point(int idx, int number) {
            this.idx = idx;
            this.number = number;
        }

        public int getIdx() {
            return idx;
        }

        public int getNumber() {
            return number;
        }
    }
}


/*
*
12 3
1 5 2 3 6 2 3 7 3 5 2 6

* startIdx < 0 인경우
* -> deque에 들어올 수를 가장 오른쪽 수와 비교한다.
* -> 작으면 들여 보낸다
* -> 가장 왼쪽의 수를 출력
*
* startIdx > 0 인 경우
* -> 들어올 idx와 가장 처음의 idx의 차이가 L 이라면 삭제
* -> deque에 들어올 수를 오른쪽 수와 비교한다.
* -> 작으면 들여보낸다
* -> 가장 왼쪽의 수를 출력한다.
*
*
* 1
* 1 5
* 1 5 2 -> 1 2
* 1 2 3
* 2 3 6
* 3 6 2 -> 2
*
*
*
* */