package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    static int N, M;
    static int minSize = -1;
    static int maxSize = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(minSize < n) {
                minSize = n;
            }
            maxSize += n;
            arr[i] = n;
        }

        int result = search();
        System.out.println(result);
    }

    static int search() {
        int lo = minSize;
        int hi = maxSize;
        int mid;

        while(lo <= hi) {
            mid = (lo + hi) / 2;
            int bluelayCnt = bluelayCnt(mid);

            if(bluelayCnt <= M) {
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int bluelayCnt(int bluelaySize) {
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i<arr.length; i++) {
            sum += arr[i];
            if(sum > bluelaySize) {
                cnt+=1;
                sum = 0;
                i -= 1;
            } else if(i == arr.length - 1) {
                cnt += 1;
                break;
            }
            if(cnt > M) {
                break;
            }
        }

        return cnt;
    }
}
