package algorithprac;

import java.util.Arrays;

public class PermutationAndCombination {
    private static int n, m;
    private static int[] arr; // 원소를 저장할 배열
    private static boolean[] visited; // 중복을 제거하기 위한 방문 처리

    public static void main(String[] args) {
        n = 4;
        m = 2;
        arr = new int[m];
        visited = new boolean[n + 1];

        permutation(0);
        combination(0, 1);
    }

    static void permutation(int cnt) {
        if(cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = 1; i<=n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static void combination(int cnt, int idx) {
        if(cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = idx; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                combination(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
