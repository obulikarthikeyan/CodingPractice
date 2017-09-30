package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a Roman string convert it to integer (0 to 3999)
 *
 * XVIII => 18
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> stringIntegerMap = getRomanNumeralMap();
        if(s == null || s.length() <= 0) {
            return 0;
        }

        int result = 0;
        for(int i=s.length()-1; i>=0; i--) {
            int current = stringIntegerMap.get(s.charAt(i));
            int next = (i > 0) ? stringIntegerMap.get(s.charAt(i-1)) : current;
            if(next < current) {
                result += current - next;
                i--;
            } else {
                result += current;
            }
        }
        return result;
    }

    private Map<Character, Integer> getRomanNumeralMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public static void main(String ...args) {
        System.out.println("Enter Roman letters in Caps");
        String s = new Scanner(System.in).nextLine();
        System.out.println("Integer equivalent of Roman String " + s + " is " + new RomanToInteger().romanToInt(s));
    }
}
