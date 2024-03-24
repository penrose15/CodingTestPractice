package programmers;

public class 문제2016년 {
    public static String solution(int a, int b) {
        int[] months = new int[]{0,31, 29, 31, 30, 31,30,31,31,30,31,30,31};

        int days = 0;
        for(int i = 0; i<a; i++) {
            System.out.println(months[i]);
            days += months[i];
        }
        days += b;

        int week = days % 7;

        if(week == 0) {
            return "SUN";
        }
        if(week == 1) {
            return "MON";
        }
        if(week == 2) {
            return "TUE";
        }
        if(week == 3) {
            return "WED";
        }
        if(week == 4) {
            return "THU";
        }
        if(week == 5) {
            return "FRI";
        }
        return "SAT";
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }
}
