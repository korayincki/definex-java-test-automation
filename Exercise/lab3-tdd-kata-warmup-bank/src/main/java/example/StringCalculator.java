package example;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        int sum = 0;
        String[] s1 = input
                .split(",");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].length()>0){
                arr[i] = Integer.valueOf(s1[i]);
                sum+=  arr[i];
            }
        }
       return sum;
    }
}
