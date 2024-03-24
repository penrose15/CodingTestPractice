package programmers;

import java.util.*;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(people);
        for (int i = people.length-1; i >= 0; i--) {
            list.add(people[i]);
        }


        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>(list);

        if(deque.size() > 1) {
            int sum = list.get(list.size()-1) + list.get(list.size()-2);
            if(sum > limit) return list.size();
        }

        while(!deque.isEmpty()) {
            int sum = deque.peekFirst() + deque.peekLast();
            if(sum > limit) {
                deque.pollFirst();
                count++;
            } else {
                deque.pollFirst();
                deque.pollLast();
                count++;
            }
            if(!deque.isEmpty()) {
                if(deque.peekLast() > Math.ceil((double) limit / 2.0)) {
                    break;
                }
            }

        }

        if(!deque.isEmpty()) {
            count += deque.size();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70,  80, 50}, 100));
    }
}
