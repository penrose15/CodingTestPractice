package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main1259 {
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        
        List<Boolean> list = new ArrayList<>();
        String str =sc.nextLine();
        
        while(!str.equals("0")){
            
            String[] strArr = str.split("");
            if(strArr.length == 1) {
                list.add(true);
            }
            else {  
                int count = 0;
                    for(int i = 0; i<(strArr.length)/2;i++) {
                        
                        if(!strArr[i].equals(strArr[strArr.length-i-1])){
                            count++;
                        }
                    }
                    if(count != 0) {
                            list.add(false);
                        }
                        else{
                            list.add(true);
                        }
                
            }
            str = sc.nextLine();
        }
        
        for(Boolean b : list) {
            if(b == true) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
        
     } 
     
}
