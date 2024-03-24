package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        List<Integer> listA = new ArrayList<>();
        for (int i : A) {
            listA.add(i);
        }

        List<Integer> listB = new ArrayList<>();
        for (int i : B) {
            listB.add(i);
        }

        int sum = 0;

        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>(listA);


        priorityQueueHighest.addAll(listB);


        while(!priorityQueueHighest.isEmpty() && !priorityQueueLowest.isEmpty()) {
            sum += priorityQueueHighest.poll() * priorityQueueLowest.poll();
        }

        return sum;
    }
}
