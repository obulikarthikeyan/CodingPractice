package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Convert the given integer (0 to 3999) into its equivalent Roman numerals
 *
 * 1148 => MCXLVIII
 * 0 => ""
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder("");
        if(num <= 0) {
            return sb.toString();
        }

        Map<Integer, String> romanNumeralMap = getRomanNumeralMap();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int x : nums) {
            while (num >= x) {
                num -= x;
                sb.append(romanNumeralMap.get(x));
            }
        }
        return sb.toString();
    }

    private Map<Integer,String> getRomanNumeralMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }

    public static void main(String ...args) {
        System.out.println("Enter an integer");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Roman Equivalent of " + x + " is " + new IntegerToRoman().intToRoman(x));
    }
}
