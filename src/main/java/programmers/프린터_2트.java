package programmers;

import java.util.*;

public class 프린터_2트 {

    static class print {
        int location;
        int priority;

        public print(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        //Queue<Integer> q = new LinkedList<>();
        Queue<print> q = new LinkedList<>();
        //
        List<Integer> priority = new ArrayList<>();
        //대충 순서대로 때려 박는다
        //List<print> printList 만들어서 for문 돌려라
        for(int i = 0; i< priorities.length; i++) {
            print p = new print(i, priorities[i]);
            q.add(p);
            priority.add(priorities[i]);
        }

        //리스트에 추가로 우선순위 넣고 내림차순 정렬
        priority.sort(Comparator.reverseOrder());

        int count = 0;
        //while(!q.isEmpty()) {
        while (!q.isEmpty()) {
            //int p = q.poll
            print p = q.poll();
            //만약 p의 위치가 location과 같고 list의 가장 첫번째라면
            if(p.location == location && p.priority == priority.get(0)) {
                //count++하고 break
                count++;
                break;
            }
            else {
                //만약 다르다면
                //만약 p의 우선순위가 list의 가장 첫번째와 같다면
                if(p.priority == priority.get(0)) {
                    //count++ 하고 q.poll
                    count++;
                    priority.remove(0);
                } else {
                    q.add(p);
                }

                //count++ 하고 q.poll
                //list.remove
                //이외는 걍 q.poll하고 다시 q.add하기 count++;
            }
            //}
        }
        //return count;
        return count;
    }
}
