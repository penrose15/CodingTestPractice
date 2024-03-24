package programmers;

public class 숫자의_표현 {
    public int solution(int n) {
        int count = 0;
        for(int i = 1; i<=n; i+=2) {
            if(n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
