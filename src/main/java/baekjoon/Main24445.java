package baekjoon;

import java.util.*;

public class Main24445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        sc.nextLine();
        int[][] arr2 = new int[n][];
        for(int i = 0; i<n;i++) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            int[] arr3 = new int[]{b,c};
            arr2[i] = arr3;
        }
        int[][] arr3 = new int[n][n];
        for(int i = 0;i< arr2.length;i++) {
            int from = arr2[i][0];
            int to = arr2[i][1];

            arr3[from][to] = 1;
            arr3[to][from] = 1;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(queue.size() !=0) {
            int from = queue.poll();
            System.out.println(from);
            for(int i = 0;i< visited.length;i++) {
                if(!visited[i] && arr3[from][i] ==1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
//    public int[] arr1(String arr) {
//
//    }

}
