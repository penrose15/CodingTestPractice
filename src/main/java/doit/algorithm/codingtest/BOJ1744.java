package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1744 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        for(int i = 0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number > 0) {
                queue.add(number);
            } else {
                minusQueue.add(number);
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(queue.isEmpty()) {
                list.add(num);
                break;
            } else {
                if(num == 1) {
                    list.add(num);
                    continue;
                }
                int num2 = queue.poll();
                if(num2 == 1) {
                    list.add(num2);
                    queue.add(num);
                } else {
                    list.add(num * num2);
                }
            }
        }

        while(!minusQueue.isEmpty()) {
            int num = minusQueue.poll();
            if(minusQueue.isEmpty()) {
                list.add(num);
                break;
            } else {
                int num2 = minusQueue.poll();
                list.add(num * num2);
            }
        }

        int sum = 0;
        for(int i = 0; i<list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
