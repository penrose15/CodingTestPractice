package programmers;

public class 큰_수_만들기_2트 {
    public static String solution(String number, int k) {
        String[] arr = number.split("");
        int[] arr1 = new int[arr.length];

        for(int i = 0; i< arr.length; i++) {
            arr1[i] = Integer.parseInt(arr[i]);
        }
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        while(k < number.length()) {

            int max = 0;
            for(int i = tmp; i<k+1; i++) {
                if(max < arr1[i]) {
                    max = arr1[i];
                    tmp = i + 1;
                }
            }
            sb.append(max);
            k += 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));
    }
}
