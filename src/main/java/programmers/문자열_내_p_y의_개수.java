package programmers;

public class 문자열_내_p_y의_개수 {
    boolean solution(String s) {
        String str = s.toLowerCase();

        int pCount = (int) str.chars().filter(e -> 'p' == e).count();
        int yCount = (int) str.chars().filter(e -> 'y' == e).count();

        return pCount == yCount;
    }
}
