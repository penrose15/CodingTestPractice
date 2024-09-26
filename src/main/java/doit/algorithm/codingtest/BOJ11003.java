package doit.algorithm.codingtest;


import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NL = br.readLine();
        int N = Integer.parseInt(NL.split(" ")[0]);
        int L = Integer.parseInt(NL.split(" ")[1]);

        String input = br.readLine();
        String[] inputArr = input.split(" ");
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(inputArr[i]);
        }

        List<Long> list = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            long now = arr[i];
            while (!deque.isEmpty() && deque.getLast().getNum() > now) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, now));

            if (deque.getFirst().getNode() <= i - L) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().getNum() + " ");
        }
        bw.flush();
        bw.close();
    }

    private static class Node {
        int node;
        long num;

        public Node(int node, long num) {
            this.node = node;
            this.num = num;
        }

        public int getNode() {
            return node;
        }

        public long getNum() {
            return num;
        }
    }
}
