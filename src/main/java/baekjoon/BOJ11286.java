package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue
                = new PriorityQueue<>((o1, o2) -> {
                    if(Math.abs(o1) == Math.abs(o2)) {
                        return o1 - o2;
                    } else {
                        return Math.abs(o1) - Math.abs(o2);
                    }
        });



        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                queue.add(num);
            } else {
                if(!queue.isEmpty()) {
                    int absNum = queue.poll();
                    System.out.println(absNum);
                } else {
                    System.out.println(0);
                }
            }
        }

    }

}
