package baekjoon;

import java.util.Scanner;

public class Main2920 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int[] arr2 = new int[arr.length];
        for(int i = 0; i< arr.length;i++) {
            int a = Integer.parseInt(arr[i]);
            arr2[i] = a;
        }

        int desc = 0;
        int asc = 0;
        for(int i = 1;i< arr2.length;i++) {
            if(arr2[i]>arr2[i-1]) {
                asc++;
            }
            else if (arr2[i]<arr2[i-1]) {
                desc++;
            }
        }
        if(asc == 7) {
            System.out.println("ascending");
        } else if (desc == 7) {
            System.out.println("descending");
        }
        else{
            System.out.println("mixed");
        }

    }

}
