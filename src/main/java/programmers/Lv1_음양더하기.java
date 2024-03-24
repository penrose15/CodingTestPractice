package programmers;

public class Lv1_음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        for(int i = 0; i < absolutes.length; i++) {
            if(!signs[i]) {
                absolutes[i] = -absolutes[i];
            }
        }

        int result = 0;
        for (int absolute : absolutes) {
            result += absolute;
        }
        return result;
    }
}
