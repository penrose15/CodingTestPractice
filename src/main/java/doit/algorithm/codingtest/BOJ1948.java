package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1948 {
    static int n;
    static int m;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();
    static int startNode;
    static int endNode;
    static int[] nodes;
    static int[] reverseNodes;
    static int[] threshold;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        nodes = new int[n + 1];
        reverseNodes = new int[n + 1];
        threshold = new int[n + 1];

        for(int i = 0; i<n+1; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            nodes[end] += 1;
            reverseNodes[start] += 1;

            graph.get(start).add(new Node(end, dist));
            reverseGraph.get(end).add(new Node(start, dist));
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()) {
            int start = queue.poll();
            for(int i = 0; i<graph.get(start).size(); i++) {
                Node linkedNode = graph.get(start).get(i);
                int end = linkedNode.end;
                int dist = linkedNode.dist;

                nodes[end] -= 1;
                threshold[end] = Math.max(threshold[end], threshold[start] + dist);
                if(nodes[end] == 0) {
                    queue.add(end);
                }
            }
        }

        int meetTime = -1;
        for(int i = 1; i<threshold.length; i++) {
            if(meetTime < threshold[i]) {
                meetTime = threshold[i];
            }
        }

        Queue<Integer> reverseQueue = new LinkedList<>();
        reverseQueue.add(endNode);
        boolean[] visited = new boolean[n+1];
        visited[endNode] = true;

        int cnt = 0;
        while(!reverseQueue.isEmpty()) {
            int start = reverseQueue.poll();

            for(int i = 0; i<reverseGraph.get(start).size(); i++) {
                Node linkedNode = reverseGraph.get(start).get(i);
                int end = linkedNode.end;
                int dist = linkedNode.dist;

                if(threshold[start] - dist == threshold[end]) {
                    cnt++;
                    if(!visited[end]) {
                        visited[end] = true;
                        reverseQueue.add(end);
                    }
                }
            }
        }
        System.out.println(meetTime);
        System.out.println(cnt);
    }

    static class Node {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
