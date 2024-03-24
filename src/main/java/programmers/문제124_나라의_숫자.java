package programmers;

public class 문제124_나라의_숫자 {
    public static String solution(int n) {
        int[] arr = {1,2,4};
        String[] str = new String[n+1];
        String s = "";

        if(n <= 3) {
            return String.valueOf(arr[n-1]);
        }
        str[0] = "0";
        str[1] = "1";
        str[2] = "2";
        str[3] = "4";

        for(int i = 4; i<=n; i++) {
            StringBuilder sb = new StringBuilder();
            int tmp = i%3;
            if(i%3 == 0) {
                tmp = 3;
            }
            str[i] = sb.append(str[(i-1)/3]).append(str[tmp]).toString();
        }
        return str[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(27));
    }
}

