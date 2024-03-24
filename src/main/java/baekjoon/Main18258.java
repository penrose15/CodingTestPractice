package baekjoon;

import java.io.*;
import java.util.*;

public class Main18258 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();

        String c = br.readLine();
        int testcase = Integer.parseInt(c);


        for (int i = 0; i < testcase; i++) {
            String method = br.readLine();
            list.add(method);
        }
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals("front")) {
                if (queue.isEmpty()){ bw.write(String.valueOf(-1));bw.write("\r\n");}
                else {bw.write(String.valueOf(queue.peekFirst()));bw.write("\r\n");}
            }
            else if (list.get(i).startsWith("push")) {
                String str = list.get(i);
                String str2 = str.substring(5);
                //숫자가 1의 자리인것만 예상하고 substring(length()-1)해버려서 개고생 함;;
                int a = Integer.parseInt(str2);
                queue.add(a);
            }

            else if (list.get(i).equals("back")) {
                if(queue.isEmpty()) {bw.write("-1"); bw.write("\r\n");}
                else {bw.write(String.valueOf(queue.peekLast())); bw.write("\r\n");}


            } else if (list.get(i).equals("pop")) {
                if (queue.isEmpty()) {bw.write(String.valueOf(-1)); bw.write("\r\n");}
                else {bw.write(String.valueOf(queue.pop())); bw.write("\r\n");}
            } else if (list.get(i).equals("size")) {
                bw.write(String.valueOf(queue.size())); bw.write("\r\n");

            } else if (list.get(i).equals("empty")) {
                if (queue.isEmpty()){ bw.write("1");bw.write("\r\n");}
                else {bw.write("0");bw.write("\r\n");}

            }


        }bw.flush();
        bw.close();
    }

}
