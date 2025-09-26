package example;

public class StringCalculator {
    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        } else if(!input.contains(",")){
            return Integer.parseInt(input);
        } else {
            int total = 0;
            String[] values = input.split(",");
            for(String i : values)
                total += Integer.parseInt(i);
            return total;
        }
    }
}
