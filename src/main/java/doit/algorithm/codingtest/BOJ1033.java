package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1033 {
    static ArrayList<Node>[] ingredients;
    static boolean[] visited;
    static long[] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ingredients = new ArrayList[N];
        visited = new boolean[N];
        resultArr = new long[N];

        for (int i = 0; i < N; i++) {
            ingredients[i] = new ArrayList<>();
        }

        StringTokenizer st;
        long lcm = 1;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            Node node = new Node(b, p, q);
            ingredients[a].add(node);
            Node node1 = new Node(a, q, p);
            ingredients[b].add(node1);

            lcm *= (p * q / getGCD(p, q));
        }



        resultArr[0] = lcm;
        dps(0, lcm);


        long result = resultArr[0];
        long totalGCD = 0;
        for (int i = 1; i < resultArr.length; i++) {
            long gcd = getGCD(result, resultArr[i]);

            totalGCD = gcd;
            result = gcd;
        }

        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] / totalGCD + " ");
        }
    }

    static void dps(int start, long mass) {
        visited[start] = true;

        for (int i = 0; i < ingredients[start].size(); i++) {
            Node node = ingredients[start].get(i);
            int b = node.getB();

            if (!visited[b]) {
                int p = node.getP();
                int q = node.getQ();
                long newMass = (mass * q) / p;
                resultArr[b] = newMass;
                dps(b, newMass);
            }
        }
    }

    static long getLCM(long a, long b, long gcd) {
        return a * b / gcd;
    }

    static long getGCD(long a, long b) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        while (a % b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return b;
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
