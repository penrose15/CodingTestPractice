package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String pattern = "^[0-9]+$";
        List<String> list = new ArrayList<>();

        String[] strArr = input.split("");
        String str = "";
        for (int i = 0; i<strArr.length; i++) {
            if(strArr[i].matches(pattern)) {
                str += strArr[i];
                if(i == strArr.length-1) {
                    list.add(str);
                }
            }
            else {
                if(strArr[i].equals("+") || strArr[i].equals("-")) {
                    list.add(str);
                    str = strArr[i];
                }
            }
            }
        List<Integer> list2 = new ArrayList<>();
        for (String s : list) {
            list2.add(Integer.parseInt(s));
        }

        int result = 0;
        int a = 1;
        for (int i = 0; i<list2.size(); i++) {
            if(list2.get(i) < 0 || a != 1) {
                if(list2.get(i) < 0) {
                    a++;
                }
                result -= Math.abs(list2.get(i));
            }
            else {
                result += list2.get(i);
            }
        }
        System.out.println(result);
        //1+2+3-4+5+6-7+8+9
        }
    }

