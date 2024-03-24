package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16434 {
    public static void main(String[] args) throws IOException {
        /*
        * 던전 공격력
        * 1 1 20
        * 2 3 10
        * 두 번째가 공격력, 세 번째가 생명력
        * 앞의 숫자가 2인 경우 몬스터의 공격력과 생명력만큼
        * 증가시켜주는 포션 제공
        *
        * 방은 순차적으로 들어갈 수 있다.
        * 던전에 들어가면 용사의 공격력만큼 몬스터의 hp가
        * 감소한다.
        * 던전에 들어가면 용사의 생명력이 몬스터의 공격력 만큼
        * 감소한다.
        * 던전에 들어가면 용사의 생명력은 max가 된다.
        *
        * 만약 용사의 생명력이 0이 되면 처음부터 시작한다
        *
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H_atk = Integer.parseInt(st.nextToken());

        int[][] dungeon = new int[N][3];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++) {
                dungeon[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long min = 1; long max = Long.MAX_VALUE-1;
        while(min <= max) {
            long mid = (min + max) / 2;
            long tmp = mid;
            long H_atk_tmp = H_atk;
            for(int i = 0; i<N; i++) {
                long monster_hp = dungeon[i][2];
                long monster_atk = dungeon[i][1];

                if(dungeon[i][0] == 2) {
                    H_atk_tmp += monster_atk;
                    if(tmp + monster_hp < mid) {
                        tmp += monster_hp;
                    } else {
                        tmp = mid;
                    }
                    continue;
                }

                long atk_cnt;

                if(monster_hp % H_atk_tmp == 0) {
                    atk_cnt = monster_hp / H_atk_tmp;
                } else {
                    atk_cnt = (monster_hp / H_atk_tmp) + 1;
                }
                tmp -= (monster_atk * (atk_cnt-1));
                if(tmp  <= 0 || i == dungeon.length-1) {

                    break;
                }
            }
            if(tmp <= 0) {
                min = mid + 1;
            }
            else {
                max = mid-1;
            }
        }
        System.out.println(min);
    }
}
