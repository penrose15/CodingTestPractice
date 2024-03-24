package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main24445_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n1 = br.readLine();
        String[] n2 = n1.split(" ");
        String a1 = n2[0];
        String a2 = n2[1];
        String a3 = n2[2];

        int n = Integer.parseInt(a1);
        int m = Integer.parseInt(a2);
        int r = Integer.parseInt(a3);
        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<m;i++) {
            String b1 = br.readLine();
            String[] b2 = b1.split(" ");
            String b3 = b2[0]; String b4 = b2[1];
            int b = Integer.parseInt(b3);
            int c = Integer.parseInt(b4);

            list.get(b).add(c);
            list.get(c).add(b);

        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(r);
        boolean[] visited = new boolean[n+1];
        visited[r] = true;
        int[] result = new int[n+1];
        int count = 1;
        result[r] = count++;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            Collections.sort(list.get(from),Collections.reverseOrder());

            for(int i : list.get(from)) {
                if(!visited[i]) {
                    visited[i] = true;
                    result[i] = count++;
                    queue.add(i);
                }
            }
        }
        for(int i = 1; i< result.length;i++) {
            System.out.println(result[i]);
        }


    }
}
