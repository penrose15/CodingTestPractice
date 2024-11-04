package algorithprac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 위상정렬
// 사이클이 없는 방향 그래프의 모든 노드를 방향성에 거스르지 않고 순서대로 나열한 것
// 진입차수(Indegree) : 특정 노드로 들어오는 간선의 수
// 진출차수(Outdegree) : 특정한 노드에서 나가는 간선의 수
public class TopologicalSorting {
    static int[] edgeCnt = new int[9];
    static ArrayList<Integer>[] graph = new ArrayList[9];
    public static void main(String[] args) {
        for(int i = 0; i<9; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 각 노드별 인접한 노드정보 초기화
        graph[1].add(2);
        graph[1].add(4);
        graph[2].add(5);
        graph[2].add(6);
        graph[3].add(6);
        graph[4].add(2);
        graph[5].add(8);
        graph[7].add(3);
        graph[8].add(6);

        // 진입차수 테이블 초기화
        edgeCnt[2] = 2;
        edgeCnt[3] = 1;
        edgeCnt[4] = 1;
        edgeCnt[5] = 1;
        edgeCnt[6] = 3;
        edgeCnt[8] = 1;

        // 위상 정렬에 사용될 큐
        Queue<Integer> queue = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for(int i = 1; i<edgeCnt.length; i++) {
            if(edgeCnt[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();

            System.out.print(node + " -> ");

            for(int i = 0; i<graph[node].size(); i++) {
                edgeCnt[graph[node].get(i)] -= 1;
                if(edgeCnt[graph[node].get(i)] == 0) {
                    queue.add(graph[node].get(i));
                }
            }
        }
    }
}
