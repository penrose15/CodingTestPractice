package programmers;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        List<List<String>> list = new ArrayList<>();
        for (String record : records) {
            String[] arr = record.split(" ");
            List<String> tmp = new ArrayList<>(Arrays.asList(arr));
            list.add(tmp);
        }

        Map<String, String> carIN = new HashMap<>();
        Map<String, Integer> accumulatedTime = new HashMap<>();

        for (List<String> carInfo : list) {

            String strTime = carInfo.get(0);
            String carNumber = carInfo.get(1);

            if (!carIN.containsKey(carNumber)&&carInfo.contains("IN")) {
                carIN.put(carNumber, strTime);
            }
            if (carIN.containsKey(carNumber) &&carInfo.contains("OUT")) {
                String inTime = carIN.get(carNumber);

                int minTime = timeSpent(inTime, strTime);

                if (accumulatedTime.containsKey(carNumber)) {
                    int a = accumulatedTime.get(carNumber);
                    accumulatedTime.put(carNumber, a + minTime);
                } else {
                    accumulatedTime.put(carNumber, minTime);
                }
                carIN.remove(carNumber);

            }
        }
        if (!carIN.isEmpty()) {
            List<String> remain = new ArrayList<>(carIN.keySet());
            for (String s : remain) {
                int minTime = timeSpent(carIN.get(s), "23:59");

                int a = 0;
                if (accumulatedTime.containsKey(s)) {
                    a = accumulatedTime.get(s);
                }
                accumulatedTime.put(s, a + minTime);
            }
        }

        int basicMoney = fees[1];
        int baseTime = fees[0];
        int unitTime = fees[2];
        int unitMoney = fees[3];

        int[] result = new int[accumulatedTime.size()];
        List<String> remain = new ArrayList<>(accumulatedTime.keySet());
        remain.sort(Comparator.naturalOrder());

        for (int i = 0; i <remain.size(); i++) {
            if (accumulatedTime.get(remain.get(i)) < baseTime) {
                result[i] = basicMoney;
            } else {
                int time = accumulatedTime.get(remain.get(i));
                int a = time - baseTime;
                int fee = basicMoney + ((int)Math.ceil((double) a / (double) unitTime) * unitMoney);
                result[i] = fee;
            }
        }
        return result;
    }

    public int timeSpent(String inTime, String outTime) {
        LocalTime in = LocalTime.parse(inTime);
        LocalTime out = LocalTime.parse(outTime);

        return (int) ChronoUnit.MINUTES.between(in, out);
    }
}
