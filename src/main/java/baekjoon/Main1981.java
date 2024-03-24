package baekjoon;

import java.util.Scanner;

public class Main1981 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int testCase = sc.nextInt();
        int[] arr = new int[testCase];

        for (int i= 0; i<testCase;i++){
            int a = sc.nextInt();
            arr[i] = a;
        }
        sc.close();
        for(int i : arr) {
            System.out.println(i);
        }


        int count = 0;
        for(int i = 0; i<testCase;i++) {
            //System.out.print(arr[i]);
            if(arr[i]<2) continue;
            else if(arr[i] == 2 || arr[i] == 3) {
                count++;
            } else {
                //int b = ;
                for(int j = 1;j<=Math.sqrt(arr[i]);j++) {
                    if(arr[i]%j != 0) {
                        count++;
                        System.out.print(arr[i]);
                    }
            }

            }
        }
        System.out.println(count);

    }

}
