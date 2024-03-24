package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 파일명_정렬 {

    static List<List<String>> list = new ArrayList<>();
    public static String[] solution(String[] files) {

        for (String file : files) {
            char[] chars = file.toCharArray();
            String intStr = "";
            int start  = chars.length;
            int last = 0;
            for(int i = 0; i< chars.length; i++) {
                if(chars[i] >= '0' && chars[i] <='9') {
                    intStr += chars[i];
                    if(start > i) {
                        start = i;
                    }
                    last = i;
                    if((i+1 < chars.length) &&(chars[i+1] > '9' || chars[i+1] < '0')) {
                        break;
                    }
                }
            }
            String head = file.substring(0, start);
            String number = intStr;
            String tail = file.substring(last+1, chars.length);
            List<String> arr = List.of(head, number, tail);
            list.add(arr);
        }
        List<List<String>> lists = list.stream()
                .sorted((o1, o2) -> {
                    if(!o1.get(0).equalsIgnoreCase(o2.get(0))) {
                        return o1.get(0).compareToIgnoreCase(o2.get(0));
                    } else {
                        int a = Integer.parseInt(o1.get(1));
                        int b = Integer.parseInt(o2.get(1));
                        if(a != b) {
                            return a-b;
                        } else {
                            return list.indexOf(o1) - list.indexOf(o2);
                        }
                    }
                }).collect(Collectors.toList());
        System.out.println(lists);

        String[] result = new String[files.length];
        for (int i = 0; i< files.length;i++) {
            result[i] = lists.get(i).get(0) + lists.get(i).get(1) + lists.get(i).get(2);
        }
        return result;
    }


    public static void main(String[] args) {
        String[] arr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
