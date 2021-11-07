package number_handler;

import exceptions.NumberSystemException;
import model.Expression;
import model.NumberSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tsypk on 07.11.2021 16:24
 * @project Calculator_kata
 * Class, that handles roman number
 */
public class RomanNumberHandler implements NumberHandler {
    private final Map<String, Integer> romanNumbs;
    private final TreeMap<Integer, String> numbs;
    private final NumberSystem system = NumberSystem.ROMAN;

    public RomanNumberHandler() {
        romanNumbs = new HashMap<>();
        numbs = new TreeMap<>();
        initRomanNumbers();
        initNumbers();
    }

    @Override
    public Integer handleNumber(String number) {
        return romanNumbs.getOrDefault(number, null);
    }

    @Override
    public String getNumberInNumberSystem(Integer number) throws NumberSystemException {
        int found = numbs.floorKey(number);
        if (number == found) {
            return numbs.get(number);
        }
        return numbs.get(found) + getNumberInNumberSystem(number - found);
    }

    @Override
    public void setNumberSystem(Expression expression) {
        expression.setSystem(system);
    }

    private void initRomanNumbers() {
        romanNumbs.put("I", 1);
        romanNumbs.put("II", 2);
        romanNumbs.put("III", 3);
        romanNumbs.put("IV", 4);
        romanNumbs.put("V", 5);
        romanNumbs.put("VI", 6);
        romanNumbs.put("VII", 7);
        romanNumbs.put("VIII", 8);
        romanNumbs.put("IX", 9);
        romanNumbs.put("X", 10);
    }

    private void initNumbers() {
        numbs.put(100, "C");
        numbs.put(90, "XC");
        numbs.put(50, "L");
        numbs.put(40, "XL");
        numbs.put(10, "X");
        numbs.put(9, "IX");
        numbs.put(5, "V");
        numbs.put(4, "IV");
        numbs.put(1, "I");
    }

}
