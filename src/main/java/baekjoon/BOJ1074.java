package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);

        int length = (int) Math.pow(2,N);

        z(length, r, c);

        System.out.println(count);


    }
    static int count = 0;

    public static void z(int length, int r, int c) {
        if(length == 1) {
            return;
        }

        if(r < length / 2 && c < length / 2) {
            z(length/2, r, c);
        }
        if(r >= length / 2 && c < length / 2) {
            count += ((int) Math.pow(length, 2) / 4) * 2;
            z(length/2 , r - length/2,c);
        }
        if(r < length / 2 && c >= length /2) {
            count += (Math.pow(length, 2)/4) * 1;
            z(length / 2, r, c - length/2);
        }
        if(r >= length / 2 && c >= length / 2) {
            count += (Math.pow(length , 2)/4) * 3;
            z(length/2, r - length/2, c - length/2);
        }
    }
}
