package programmers;

import java.util.Arrays;

public class 정수_삼각형 {
    public static int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] arr= new int[n][n];

        for(int i = 0; i< triangle.length; i++) {
            Arrays.fill(arr[i], -1);
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                arr[i][j] = triangle[i][j];
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for(int i = 0; i<n-1; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i+1][j] == -1) continue;
                if(j > 0 && j < triangle[i].length) {
                    arr[i+1][j] += Math.max(arr[i][j], arr[i][j-1]);
                } else if(j == 0) {
                    arr[i+1][j] += arr[i][j];
                } else if(j == triangle[i].length) {
                    arr[i+1][j] += arr[i][j-1];
                }
            }
        }
        Arrays.sort(arr[n-1]);
        return arr[n-1][n-1];
    }

    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4}, {4,5,2,6,5}};
        System.out.println(solution(triangle));
    }
}
