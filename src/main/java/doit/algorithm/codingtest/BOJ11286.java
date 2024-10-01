package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.getAbs() == o2.getAbs()) {
                return o1.getNum() - o2.getNum();
            }
            return o1.getAbs() - o2.getAbs();
        });

        for(int i = 0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n != 0) {
                Node node = new Node(Math.abs(n), n);
                queue.add(node);
            } else {
                if(!queue.isEmpty()) {
                    Node polledNode = queue.poll();
                    System.out.println(polledNode.getNum());
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    private static class Node {
        int abs;
        int num;

        public Node(int abs, int num) {
            this.abs = abs;
            this.num = num;
        }

        public int getAbs() {

            return abs;
        }

        public int getNum() {
            return num;
        }
    }
}
