package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] gears = new int[4][8];
        StringTokenizer st;

        for(int i = 0; i<gears.length; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j<8;j++) {
                gears[i][j] = Integer.parseInt(str[j]);
            }
        }

        int spin = Integer.parseInt(br.readLine());
        int[][] spins = new int[spin][2];

        for(int i = 0; i<spins.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<2; j++) {
                spins[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] d;
        for(int i = 0; i<spins.length; i++) {
            int gearN = spins[i][0] - 1;
            int dir = spins[i][1];
            d = new int[4];
            d[gearN] = dir;
            for(int j = gearN; j > 0; j--) {
                if(gears[j][6] == gears[j-1][2]) {
                    break;
                } else {
                    d[j-1] = -d[j];
                }
            }
            for(int j = gearN; j<3;j++) {
                if(gears[j][2] == gears[j+1][6]) {
                    break;
                } else {
                    d[j+1] = -d[j];
                }
            }

            for(int j = 0; j<d.length; j++) {
                if(d[j] == 0) continue;
                else if(d[j] == 1) {
                    int tmp = gears[j][7];
                    for(int k = 7; k>0; k--) {
                        gears[j][k] = gears[j][k-1];
                    }
                    gears[j][0] = tmp;

                }
                else if(d[j] == -1) {
                    int tmp = gears[j][0];
                    for(int k = 0; k<7; k++) {
                        gears[j][k] = gears[j][k+1];
                    }
                    gears[j][7] = tmp;
                }
            }
        }


        int result = gears[0][0] + gears[1][0] * 2
                + gears[2][0] * 4 + gears[3][0] * 8;

        System.out.println(result);
    }
}
