package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String test = "";
        int[] arr = new int[3];
        String[] str;
        boolean bool = true;
        List<String> list = new ArrayList<>();
        while (bool){
            test = bf.readLine();
            str = test.split(" ");
            for(int i=0; i< str.length;i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            if(arr[0] == 0) {
                break;
            }
            if(arr[0]*arr[0] == (arr[1]*arr[1])+ (arr[2]*arr[2])){
                list.add("right");
            }
            else if(arr[1]*arr[1] == (arr[2]*arr[2])+ (arr[0]*arr[0])){
                list.add("right");
            }
            else if(arr[2]*arr[2] == (arr[1]*arr[1])+ (arr[0]*arr[0])){
                list.add("right");
            }
            else {
                list.add("wrong");
            }
        }for(String s : list) {
            System.out.println(s);
        }

    }

}
