package algorithprac;

public class BinaryTree {
    /*
    * 각 노드의 자식 노드의 개수가 2이하로 구성되어 있는 트리
    * */
    static int N;
    static int[][] tree;
    public static void main(String[] args) {
        N = 7;
        tree = new int[26][2];

    }

    static void preOrder(int node) {
        if(node == -1) {
            return;
        }

        System.out.println(node);
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    static void inOrder(int node) {
        if(node == -1) {
            return;
        }

        inOrder(tree[node][0]);
        System.out.println(node);
        inOrder(tree[node][1]);
    }

    static void postOrder(int node) {
        if(node == -1) {
            return;
        }

        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.println(node);
    }
}
