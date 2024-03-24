package baekjoon;

import java.util.Scanner;

public class Main1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int testCase = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[testCase];

        for (int i= 0; i<testCase;i++){
            int a = sc.nextInt();
            arr[i] = a;
        }
        int count = 0;
        for(int i = 0; i< arr.length;i++) {
            if(arr[i]==1) {
                continue;
            }
            else if(arr[i] == 2 || arr[i]==3) {
                count++;
            }
            else if(arr[i]%2 == 0) {
                continue;
            }
            else{
                double sqrt = Math.sqrt((double)arr[i]);
                int num = (int)Math.ceil(sqrt);
                int a = 0;
                for(int j = 3; j<=num;j++) {

                    if(arr[i]%j ==0){
                        a++;
                    }
                }
                if(a ==0) {
                    count++;
                }
            }//


        }
        System.out.println(count);
    }
}
