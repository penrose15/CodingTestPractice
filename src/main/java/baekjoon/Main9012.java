package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) {
        //일단 먼저 숫자 입력을 받아야 함
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[test];
        //그리고 for문을 입력 받은 수 만큼 반복해야 함
        for(int i = 0; i<test;i++) {
            //문자열로 입력받음
            String str = sc.nextLine();
            //배열에 저장
            arr[i] = str;
        }
        for(int i = 0; i<arr.length;i++) {
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();
            //split으로 문자 배열로 분해
            String[] arr1 = arr[i].split("");
            //for 문 돌려서 stack에 push 함

            if(arr1.length%2 == 1){
                System.out.println("NO"); continue;
            }
            else {
                for(int j = arr1.length-1; j>=0;j--) {
                    stack1.push(arr1[j]);
                }
                int count = 0;
                for(int k = 0;k< arr1.length;k++) {
                    String chr = stack1.pop();
                    if(chr.equals("(")){
                        count++;
                    } else if (chr.equals(")")) {
                        count--;
                    }
                    if(count<0) {
                        System.out.println("NO");
                        break;
                    }
                }
                if(count == 0){
                    System.out.println("YES");
                }
                else if(count>0){
                    System.out.println("NO");
                }

            }

           // }
            //그리고 ) 와 ( 의 갯수를 각각 세서
        }
        //같으면 yes, 아니면 no
        //문제는...이게 예외케이스가 있는데 ))((이면 yes라고 나옴  -> 인덱스 0번째가 )이면 no출력으로 해결 가능


    }
}
