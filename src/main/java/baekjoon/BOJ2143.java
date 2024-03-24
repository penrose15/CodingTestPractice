package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[n+1];

        for(int i = 1; i<n+1; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] B = new long[m+1];

        for(int i = 1; i<m+1; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        long cnt = 0;

        for(int i = 1; i<n+1; i++) {
            A[i] = A[i-1] + A[i];
        }
        for(int i = 1; i<m+1; i++) {
            B[i] = B[i-1] + B[i];
        }


        List<Long> listB = new ArrayList<>();
        for(int i = 1; i<B.length; i++) {
            for(int j = 0; j<i; j++) {
                listB.add(B[i] - B[j]);
            }
        }

        listB.sort(Comparator.naturalOrder());

        long[] bArr = listB.stream()
                        .mapToLong(i -> i)
                                .toArray();

        Map<Long, Integer> mapA = new HashMap<>();
        for(int i = 1; i< A.length; i++) {
            for(int j = 0; j<i; j++) {
                long a1 = A[i] - A[j];
                if(!mapA.containsKey(a1)) {
                    mapA.put(a1, 1);
                } else {
                    int value = mapA.get(a1);
                    mapA.put(a1, value + 1);
                }
            }
        }

        long[] aArr = new long[mapA.size()];
        List<Long> list = new ArrayList<>(mapA.keySet());
        list.sort(Comparator.naturalOrder());

        for(int i = 0; i<aArr.length; i++) {
            aArr[i] = list.get(i);
        }

        for(int i = 0; i< bArr.length; i++) {
            long b = bArr[i];

            int left = 0; int right = aArr.length-1;
            while (left <= right) {
                int mid = (left + right)/2;

                long a = aArr[mid];

                if(a + b <= T) {
                    if(a + b == T) {
                        cnt += mapA.get(a);
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }


        System.out.println(cnt);

    }
}
