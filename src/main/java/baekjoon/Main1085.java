package baekjoon;

import java.util.Scanner;

public class Main1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[] arr = new int[4];
        arr[0] = x; arr[1] = y; arr[2] = w-x; arr[3]=h-y;

        int min = arr[0];
        for(int i = 1; i< arr.length;i++) {
            if(min>=arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
