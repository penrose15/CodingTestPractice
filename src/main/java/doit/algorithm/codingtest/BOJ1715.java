package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i = 0; i<N; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        if(queue.size() == 1) {
            System.out.println(0);
            return;
        }

        long ans = 0;
        while(!queue.isEmpty()) {
            long card1 = queue.poll();

            if(!queue.isEmpty()) {
                long card2 = queue.poll();
                long sum = card1 + card2;
                ans += sum;
                queue.add(sum);
            } else {
                break;
            }

        }

        System.out.println(ans);

    }
}
