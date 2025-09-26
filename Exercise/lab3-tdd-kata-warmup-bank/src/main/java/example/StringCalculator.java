package example;

public class StringCalculator {
    public int add(String input) {
    try{
        if(input.length()>=2){
        String[] strArray = input.split(",");
        int total = 0;
        for(int i = 0; i <= strArray.length -1; i++){
            total = total + Integer.parseInt(strArray[i]);
        }
        return total;
        }
        else if(input.length() == 1){
            return Integer.parseInt(input);
        }
        return 0;
    }
    catch(UnsupportedOperationException e){
        throw e;
        }
    }
}
