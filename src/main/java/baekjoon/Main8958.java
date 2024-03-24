package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main8958 {


    //만약 O면
        //전이 O인 경우
        //전이 X인 경우
    //만약 X면
        //초기화
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();

        ArrayList<String[]> arr = new ArrayList<>();
        //배열로 만듬
        for(int i = 0; i<testcase;i++) {
            String quiz = sc.nextLine();
            String[] arr2 = quiz.split("");
            arr.add(arr2);
        }

        int score =1;
        int sum = 0;
        for(int i = 0; i< arr.size();i++) {
            sum = 0;
            for(int j = 0;j<arr.get(i).length;j++) { //OOXXOOXXOO
                if(arr.get(i)[j].equals("X")) {
                    score = 0;
                    sum+=score;
                }
                else if(arr.get(i)[j].equals("O")) {
                    if(j ==0) {
                        score = 1;
                        sum +=score;
                    }
                    else if(arr.get(i)[j].equals(arr.get(i)[j-1]) && j !=0) {
                        score+=1;
                        sum +=score;
                    }  else {
                        score = 1;
                        sum +=score;
                    }
                }

            }System.out.println(sum);

        }
    }
}
