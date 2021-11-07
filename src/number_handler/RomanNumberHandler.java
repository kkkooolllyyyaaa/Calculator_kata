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
    private final TreeMap<Integer, String> arabicNumbs;
    private final NumberSystem system = NumberSystem.ROMAN;

    public RomanNumberHandler() {
        romanNumbs = new HashMap<>();
        arabicNumbs = new TreeMap<>();
        initRomanNumbers();
        initArabicNumbers();
    }

    @Override
    public Integer handleNumber(String number) {
        return romanNumbs.getOrDefault(number, null);
    }

    @Override
    public String getNumberInNumberSystem(Integer number) throws NumberSystemException {
        int found = arabicNumbs.floorKey(number);
        if (number == found) {
            return arabicNumbs.get(number);
        }
        return arabicNumbs.get(found) + getNumberInNumberSystem(number - found);
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

    private void initArabicNumbers() {
        arabicNumbs.put(1, "I");
        arabicNumbs.put(4, "IV");
        arabicNumbs.put(5, "V");
        arabicNumbs.put(9, "IX");
        arabicNumbs.put(10, "X");
        arabicNumbs.put(40, "XL");
        arabicNumbs.put(50, "L");
        arabicNumbs.put(90, "XC");
        arabicNumbs.put(100, "C");
    }
}
