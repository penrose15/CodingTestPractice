package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        List<String[]> list2 = new ArrayList<>();
        for (int i = 0; i < testcase; i++) {
            int repeat = sc.nextInt();
            String word = sc.nextLine();
            list.add(repeat);
            String str2 = word.trim();
            list2.add(str2.split(""));
        }
        for (int i = 0; i < testcase; i++) {
            for (int j = 0; j < list2.get(i).length; j++) {
                for (int k = 0; k < list.get(i); k++) {
                    System.out.print(list2.get(i)[j]);
                }
            }
            System.out.println("");
        }
    }
}
