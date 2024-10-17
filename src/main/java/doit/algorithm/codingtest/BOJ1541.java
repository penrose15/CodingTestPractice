package doit.algorithm.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input = br.readLine();
        String[] arr = input.split("");

        List<String> list = new ArrayList<>();
        StringBuilder a = new StringBuilder();
        for(int i = 0; i<arr.length; i++) {
            String str = arr[i];
            if(!str.equals("+") && !str.equals("-")) {
                a.append(str);
            } else {
                list.add(a.toString());
                a = new StringBuilder();
                list.add(str);
            }

            if(i == arr.length - 1) {
                list.add(a.toString());
            }
        }

        int idx = 0;
        int sum = 0;
        boolean isMinus = false;
        while(idx < list.size()) {
            String str = list.get(idx);
            if(!str.equals("+") && !str.equals("-")) {
                int num = Integer.parseInt(str);
                if(!isMinus) {
                    sum += num;
                } else {
                    sum -= num;
                }
                idx++;
            } else if(str.equals("-")) {
                isMinus = true;
                idx++;
            } else {
                idx++;
            }
        }

        System.out.println(sum);
    }
}
