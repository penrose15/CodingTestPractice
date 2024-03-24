package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        // input 2줄

        // 각각 변환 1번째 줄 -> 숫자 2번째 줄 -> 배열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String scores = br.readLine();
        String[] arr = scores.split(" ");
        double[] scoreArr = new double[N];
        for(int i = 0; i<scoreArr.length; i++) {
            scoreArr[i] = Integer.parseInt(arr[i]);
        }

        // 배열의 최댓값을 구한다.
        double max = Integer.MIN_VALUE;
        for(int i = 0; i<scoreArr.length; i++) {
            if(max <= scoreArr[i]) {
                max = scoreArr[i];
            }
        }

        // 배열을 돌면서 평균을 구한다.
        double totalScore = 0;
        for(int i = 0; i<scoreArr.length; i++) {
            totalScore += scoreArr[i];
        }
        double mid = totalScore / N;

        // 조작한다
        double result = (mid / max) * 100;

        System.out.println(result);

    }
}
