package example;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String input) {
        if(input.isEmpty()) return 0;

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        return numbers.stream().reduce(0, Integer::sum);

    }
}
