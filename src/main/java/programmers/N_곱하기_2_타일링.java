package programmers;

public class N_곱하기_2_타일링 {
    public static int solution(int n) {
        long[] arr = new long[n+1];

        if(n <= 3) {
            return n;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        for(int i = 3; i<=n; i++) {
            arr[i] = (arr[i-1]%1_000_000_007) + (arr[i-2]%1_000_000_007);
            arr[i]%=1_000_000_007;
        }

        return (int) arr[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(6));
    }
}
