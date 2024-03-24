package programmers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class 방문_길이 {

    static int length = 0;
    public static int solution(String dirs) {

        String[] command = dirs.split("");
        calculateVisited(command);

        return length;

    }

    public static void calculateVisited(String[] command) {
        int x = 5; int y = 5;
        List<Set<Point>> list = new ArrayList<>();
        for (String s : command) {
            switch (s) {
                case "U":

                    if (y+1 > 10 || y+1 < 0 || x > 10 || x < 0) continue;
                    y+=1;
                    Point p1 = new Point(x,y);
                    Point p2 = new Point(x,y-1);
                    Set<Point> set = Set.of(p1, p2);
                    if (!list.contains(set)) {
                        length++;
                        list.add(set);
                    }
                    break;
                case "D":
                    if (y-1 > 10 || y-1 < 0|| x > 10 || x < 0) continue;
                    y -=1;
                    p1 = new Point(x,y);
                    p2 = new Point(x,y+1);
                    set = Set.of(p1, p2);
                    if (!list.contains(set)) {
                        length++;
                        list.add(set);
                    }

                    break;
                case "L":

                    if (x-1 > 10 || x-1 < 0 || y > 10 || y < 0) continue;
                    x -= 1;
                    p1 = new Point(x,y);
                    p2 = new Point(x+1,y);
                    set = Set.of(p1, p2);
                    if (!list.contains(set)) {
                        length++;
                        list.add(set);
                    }
                    break;
                default:

                    if (x+1 > 10 || x+1 < 0 || y > 10 || y < 0) continue;
                    x += 1;
                    p1 = new Point(x,y);
                    p2 = new Point(x-1,y);
                    set = Set.of(p1, p2);
                    if (!list.contains(set)) {
                        length++;
                        list.add(set);
                    }
                    break;
            }
//            move(x,y,command[i]);
        }
    }

    public static void main(String[] args) {
        String dir = "ULURRDLLU";

        System.out.println(solution(dir));
    }
}
