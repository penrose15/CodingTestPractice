package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main10818 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int num1 = Integer.parseInt(num);

        String num2 = br.readLine();
        String[] arr = num2.split(" ");
        int[] arr2 = new int[num1];
        for (int i = 0; i < num1; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }
        List<Integer> list = Arrays.stream(arr2).boxed().collect(Collectors.toList());

        Integer max = list.stream()
                .mapToInt(m -> m)
                .max()
                .orElseThrow(NoSuchElementException::new);
        Integer min = list.stream()
                .mapToInt(m -> m)
                .min()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(min+" "+max);


    }
}


