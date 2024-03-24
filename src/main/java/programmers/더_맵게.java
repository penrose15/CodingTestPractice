package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 더_맵게 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i : scoville) {
            priorityQueue.add(i);
        }
        int count = 0;
        try{
            while (priorityQueue.peek() < K) {
                int now = priorityQueue.size();
                int a = priorityQueue.poll();
                if (a < K) {
                    int newFood = a + (priorityQueue.poll() * 2);
                    priorityQueue.add(newFood);
                    count++;
                }
            }
        } catch (Exception e) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 9, 10, 12};

        System.out.println(solution(a, 7));
    }
}
