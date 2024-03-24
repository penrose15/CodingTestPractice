package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = 0;

        for(int i : lectures) {
            max += i;
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            int tmp = 0;
            int midTmp = mid;
            for(int i = 0; i<N; i++) {
                if(mid < lectures[i]) {
                    tmp = M + 1;
                    break;
                } else {
                    midTmp -= lectures[i];
                    if(i < N-1 && midTmp < 0) {
                        tmp +=1;
                        midTmp = mid;
                        midTmp -= lectures[i];
                    } else if(i == N-1){
                        if(midTmp < 0) {
                            tmp +=2;
                        } else {
                            tmp +=1;
                        }
                    }
                }
            }
            if(tmp > M) {
                min = mid + 1;
            }
            else {
                max = mid-1;
            }
        }
        System.out.println(min);
    }
}
