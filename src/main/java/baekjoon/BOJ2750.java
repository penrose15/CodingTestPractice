package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int N = Integer.parseInt(line1);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            String line = br.readLine();
            int num = Integer.parseInt(line);
            list.add(num);
        }
        list.sort(Comparator.comparingInt(a -> a));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<list.size(); i++) {
            bw.write(list.get(i).toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
