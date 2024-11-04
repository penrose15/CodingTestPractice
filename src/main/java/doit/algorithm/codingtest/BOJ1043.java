package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1043 {
    static int N;
    static int M;
    static int[] parent;
    static int[] truthArr;
    static ArrayList<Integer>[] parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        if (number != 0) {
            truthArr = new int[number];
            int idx = 0;
            while (st.hasMoreElements()) {
                truthArr[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        } else {
            truthArr = new int[0];
        }

        parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
            }
        }

        for(int i = 0; i<M; i++) {
            int first = parties[i].get(0);
            for(int j = 1; j<parties[i].size(); j++) {
                // union
                int second = parties[i].get(j);
                union(first, second);
                first = second;
            }
        }

        for(int i = 0; i<truthArr.length; i++) {
            int knowTruth = truthArr[i];
            //find parent and save
            int parentNumber = find(knowTruth);
            truthArr[i] = parentNumber;
        }

        List<Integer> truthList = Arrays.stream(truthArr)
                .boxed()
                .collect(Collectors.toList());

        int cnt = 0;
        for (int i = 0; i<M; i++) {
            boolean hasTruth = false;
            int person = parties[i].get(0);
            int parentNumber = find(person);
            if(truthList.contains(parentNumber)) {
                hasTruth = true;
            }
            if(!hasTruth) cnt += 1;
        }

        System.out.println(cnt);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}
