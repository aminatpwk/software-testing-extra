package tdd;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static Map<String, Integer> table = new HashMap<>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public int convert(String roman) {
        int finalNumber = 0;
        int lastNeighbor = 0;
        for(int i = roman.length()-1; i>=0; i--) {
            int current = table.get(roman.charAt(i));
            int multiplier = 1;
            if(current < lastNeighbor) {
                multiplier = -1;
            }
            int currentNumberToBeAdded = current * multiplier;
            finalNumber += currentNumberToBeAdded;
            lastNeighbor = current;
        }
        return finalNumber;
    }
}
