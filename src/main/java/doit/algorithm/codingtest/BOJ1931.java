package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[N];

        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Meeting meeting = new Meeting(start, end);

            arr[i] = meeting;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.getEnd() == o2.getEnd()) {
                return o1.getStart() - o2.getStart();
            }

            return o1.getEnd() - o2.getEnd();
        });

        int cnt = 1;
        int idx1 = 0;
        int idx2 = 1;
        while(idx2 < N) {
            Meeting meeting = arr[idx1];
            int end = meeting.getEnd();

            Meeting meeting2 = arr[idx2];
            int start = meeting2.getStart();

            if(start > end) {
                idx1 = idx2;
                idx2 += 1;
                cnt += 1;
            } else {
                idx2 += 1;
            }

        }

        System.out.println(cnt);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
