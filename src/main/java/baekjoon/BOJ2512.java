package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] region = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            region[i] = Integer.parseInt(st.nextToken());
        }

        int total_budget = Integer.parseInt(br.readLine());

        int max = total_budget;
        int min = 0;


        while (min < max-1) {
            int mid = (max + min) / 2;
            int sum = 0;
            for(int i = 0; i<N; i++) {
                int budget = region[i];
                if(budget > mid) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }
            if(sum > total_budget) {
                max = mid;
            } else {
                min = mid;
            }
        }
        int max_region_budget = -1;
        for(int i = 0; i<N; i++) {
            if(max_region_budget < region[i]) {
                max_region_budget = region[i];
            }
        }
        if(max_region_budget < min) {
            min = max_region_budget;
        }

        System.out.println(min);
    }
}
