package baekjoon;
    /*상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는

     설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

    상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도

    되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.

    상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.*/

import java.util.Scanner;

public class Main2839 {
    public static void main(String[] args) {
        int bag1 = 3;
        int bag2 = 5;
        int count, count2, left, left2 = 0;
        boolean a = true;

        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();

        //먼저 설탕을 5kg으로 나누었을때 완벽히 나누어 떨어지면 count에 몫을 할당한다
        if(sugar%bag2 == 0) {
            count = sugar/bag2;
            System.out.println(count);
        }
        //완벽히 나누어 떨어지지 않으면 나머지를 3으로 나눈다
        else if(sugar%bag2 != 0) {
            count = sugar/bag2;
            left = sugar%bag2;
            left2 = left%bag1;
            count2 = left/bag1;
            //만약 3으로 나눈것이 나누어 떨어지면 count에 더하고 아니면 count에 1을 빼고 left에 5를 더한 후 위를 반복한다.
            if(left2 == 0) {
                count = count + count2;
                System.out.println(count);
            }
            else {
                while(a == true) {
                    count--;
                    left = left+bag2;
                    left2 = left%bag1;
                    count2 = left/bag1;

                    if(count<0) {
                        count =-1;
                        System.out.println(count);
                        a = false;
                    }
                    else if(left2 == 0) {
                        count = count + count2;
                        System.out.println(count);
                        a = false;
                    }
                }
            }
        }
        else if(sugar%bag1 == 0) {
            count = sugar/bag1;
            System.out.println(count);
        }

        /*
        * 만약 count == 0인데 left2 !=0이면 count =-1
        *
        * */
    }

}
