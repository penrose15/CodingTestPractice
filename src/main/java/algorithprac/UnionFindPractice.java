package algorithprac;

import java.io.IOException;

public class UnionFindPractice {
    /*
    * 그래프/트리의 대표적 알고리즘
    * union : 각 노드가 속한 집합을 1개로 합치는 연산
    * find : 특정 노드 a에 관해 a가 ㅅ속한 집합의 대표 노드를 반환하는 연산
    * */
    static int[] parent;
    public static void main(String[] args) throws IOException {
        int n = 5;
        parent = new int[n + 1];
        for(int i = 1; i<parent.length; i++) {
            parent[i] = i;
        }

        union(1, 2);
        parentPrint();
        union(3, 4);
        parentPrint();
        union(3, 5);
        parentPrint();
        System.out.println("find(2) " + find(2));
        System.out.println("find(4) " + find(4));
        union(2, 4);
        parentPrint();
        System.out.println("find(4) " + find(4));
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public static void parentPrint() {
        System.out.print("[");
        for(int i = 1; i<parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println("]");
    }
}
