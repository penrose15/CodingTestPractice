package baekjoon;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main10757 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //원래는 bufferedReader쓰려고 했으나 long로 입력 받으려면 parseLong(br.readLing());를 써야 하는데 
        //그러면 readLine()을 써야 하는데 한 줄을 통째로 인식을 해서 1000 1000000이런 식으로 입력하면 한줄을 다 읽어 
        //숫자로 형변환이 안됨
        //그래서 어쩔수 없이 스캐너 클래스를 사용했고

        String a = sc.next();
        String a2 = sc.next();

        BigDecimal num1 = new BigDecimal(a);
        BigDecimal num2 = new BigDecimal(a2);
        //얘가 핵심인데 ㅈ나 큰 수일때 사용 가능한 숫자이다
        //실수 나누기 할때 소수 몇자리 정확하게 출력할때 사용된다
        //다만 나누기시 소숫점 몇자리 출력할지 정해야 함
        
        System.out.println(num1.add(num2));
    }
}
