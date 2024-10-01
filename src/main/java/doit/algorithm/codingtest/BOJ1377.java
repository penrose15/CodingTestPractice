package doit.algorithm.codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] nodeArr = new Node[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            Node node = new Node(i, num);
            nodeArr[i] = node;
        }
        Arrays.sort(nodeArr, Comparator.comparingInt(Node::getNumber));

        int max = -1;

        for (int i = 0; i < nodeArr.length; i++) {
            Node node = nodeArr[i];
            int idx = node.getIdx();
            if (max < idx - i) {
                max = idx - i;
            }
        }

        System.out.println(max + 1);

    }

    private static class Node {
        int idx;
        int number;

        public Node(int idx, int number) {
            this.idx = idx;
            this.number = number;
        }

        public int getIdx() {
            return idx;
        }

        public int getNumber() {
            return number;
        }
    }
}