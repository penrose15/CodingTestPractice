package baekjoon;

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
        for(int i = 1; i<=N; i++) {
            queue.add(i);
        }
        int result = queue.peek();
        while (!queue.isEmpty()) {
            result = queue.poll();
            if(queue.size() > 1) {
                int n = queue.poll();
                queue.add(n);
            } else {
                if (queue.size() == 1) {
                    result = queue.peek();
                }
            }
        }
        System.out.println(result);
    }
}

/*
*
* 1 2 3 4
*
*
* */
