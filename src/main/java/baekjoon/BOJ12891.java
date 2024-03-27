package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] arr = str.toCharArray();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // s = 4 -> 0 1 2 3
        int startIdx = 0;
        int endIdx = startIdx + p - 1;
        int aCnt = 0;
        int cCnt = 0;
        int gCnt = 0;
        int tCnt = 0;

        for(int i = startIdx; i<= endIdx; i++) {
            if(arr[i] == 'A') aCnt++;
            if(arr[i] == 'C') cCnt++;
            if(arr[i] == 'G') gCnt++;
            if(arr[i] == 'T') tCnt++;
        }

        int result = 0;
        while(endIdx < s) {
            if(aCnt >= A && cCnt >= C && gCnt >= G && tCnt >= T) {
                result+=1;
            }
            char start = arr[startIdx];
            if(start == 'A') {
                aCnt -=1;
            }
            if(start == 'C') {
                cCnt -=1;
            }
            if(start == 'G') {
                gCnt -=1;
            }
            if(start == 'T') {
                tCnt -=1;
            }
            startIdx += 1;
            endIdx += 1;
            if(endIdx == s) break;
            char end = arr[endIdx];
            if(end == 'A') {
                aCnt +=1;
            }
            if(end == 'C') {
                cCnt +=1;
            }
            if(end == 'G') {
                gCnt +=1;
            }
            if(end == 'T') {
                tCnt +=1;
            }
        }
        System.out.println(result);
    }
}
