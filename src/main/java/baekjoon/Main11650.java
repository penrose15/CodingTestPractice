package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11650 {
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for(int i = 0; i< N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x; arr[i][1] = y;
        }
        //comparator 사용
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] -o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

/*
        //lambda 사용
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] -o2[1];
            else return o1[0]-o2[0];
        });
*/

        for(int i = 0; i<arr.length; i++) {
            System.out.println(arr[i][0]+ " "+ arr[i][1]);
        }
    }

}
