package programmers;

import java.util.ArrayList;
import java.util.List;

public class 모음_사전_dfs {
    List<String> list = new ArrayList<>();
    String aeiou = "AEIOU";
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }

    void dfs(String str, int depth) {
        if(depth > 5) return;
        list.add(str);
        for(int i = 0; i<5; i++) {
            dfs(str + aeiou.charAt(i), depth+1);

        }
    }
}
