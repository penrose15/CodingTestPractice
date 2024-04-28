package baekjoon;

import java.io.*;

public class BOJ10989 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxLen = 0;
        for (int i : arr) {
            int max = i != 0 ? (int) Math.floor(Math.log10(Math.abs(i))) + 1 : 1;
            if(max > maxLen) {
                maxLen = max;
            }
        }

        for(int i = 0; i<maxLen; i++) {
            A = new int[N];
            int[] digitLen = new int[10];
            for(int j = 0; j<N; j++) {
                int digitNum = (int) (Math.floor(arr[j] / Math.pow(10, i))) % 10;
                digitLen[digitNum] += 1;
            }
            for(int j = 1; j<10; j++) {
                digitLen[j] += digitLen[j-1];
            }
            for(int j = N-1; j>=0; j--) {
                int digitNum = (int) (Math.floor(arr[j] / Math.pow(10, i))) % 10;
                A[digitLen[digitNum]-1] = arr[j];
                digitLen[digitNum] -= 1;
            }

            for(int j = 0; j<N; j++) {
                arr[j] = A[j];
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<arr.length; i++) {
            bw.write(arr[i] + "\n");
        }


        bw.flush();
        bw.close();
    }
}
