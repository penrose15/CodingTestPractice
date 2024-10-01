package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (queue.size() > 1) {
            if (cnt % 2 == 0) {
                queue.poll();
            } else {
                int num = queue.poll();
                queue.add(num);
            }
            cnt++;
        }

        int result = queue.poll();
        System.out.println(result);
    }
}
