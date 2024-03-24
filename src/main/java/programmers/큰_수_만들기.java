package programmers;

import java.util.*;

public class 큰_수_만들기 {
    public static String solution(String number, int k) {
        List<Integer> list1 = new ArrayList<>();
        String[] str = number.split("");
        int[] arr = new int[str.length];
        for (int i = 0; i< str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        String s = "";
        boolean[] visited = new boolean[number.length()];
        int length = number.length() - k;
        for(int i = 0; i < number.length(); i++) {
            int max = arr[i];
            int maxI = i;
            int end = i + length - 1 <= number.length() ? i + length - 1 : number.length();
            for(int j = i + 1;j < end; j++) {
                if(max < arr[j] && !visited[j]) {
                    max = arr[j];
                    maxI = j;
                }
            }
            s += max;
            visited[maxI] = true;
            i = maxI;
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }
}
