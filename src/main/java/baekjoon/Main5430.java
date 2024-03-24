package baekjoon;

import java.io.*;
import java.util.*;

public class Main5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        loop :
        for(int i = 0; i< testcase;i++) {
            String func = br.readLine();
            String[] funcArray = func.split("");
            int size = Integer.parseInt(br.readLine());

            String arr = br.readLine();
            arr = arr.replaceAll("[\\[\\]]","");
            String[] array = arr.split(",");
//            System.out.println(Arrays.toString(array));

            Deque<Integer> deque = new ArrayDeque<>();

            if(array.length < 1);
            else {
                for(int j = 0; j < size; j++) {
                    int a = Integer.parseInt(array[j]);
                    deque.offerLast(a);
                }
//                System.out.println(deque);
            }
            boolean error = false;
            boolean flip = false;
            for (int l =0; l < funcArray.length; l++) {
                if(funcArray[l].equals("R")) {
                    flip = !flip;
                } else if(funcArray[l].equals("D")) {
                    if(deque.size() == 0) {
                        error = !error;
                        break;
                    }
                    if(!flip) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }
            if(error == true) {
                bw.write("error");
            }
            else if(!flip) {
                String result = deque.toString();
                result = result.replaceAll(" ","");
                bw.write(result);
            } else {
                List<Integer> list= new ArrayList<>(deque);
                Collections.reverse(list);
                String result = list.toString();
                result = result.replaceAll(" ", "");
                bw.write(result);
            }
            bw.write("\n");


        }
        bw.flush();
        bw.close();
    }
}
