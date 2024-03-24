package programmers;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열의합 {
    static Set<Integer> set = new HashSet<>();

    public static int solution(int[] elements) {
        int[] arr = new int[elements.length * 2 - 1];
        System.arraycopy(elements, 0, arr, 0, elements.length);
        for(int i = 0; i<elements.length-1; i++) {
            arr[i+ elements.length] = elements[i];
        }
        for(int i = 1; i<= elements.length; i++) {
            dp(arr, i);
        }
        System.out.println(set);

        int result = set.size();

        return result;

    }

    public static void dp (int[] arr, int a) {
        for(int i = 0; i<arr.length-a; i++) {
            int sum = 0;
            for(int j = 0; j<a; j++) {
                sum += arr[j+i];
            }
            set.add(sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }
}
