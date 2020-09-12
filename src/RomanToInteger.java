/**
 * Created by dbaofd on 2020/9/12.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> romeMap = new HashMap<>();
        Map<Character, Integer> priorityMap = new HashMap<>();
        HashSet<Character> specialChar = new HashSet<>();
        romeMap.put("I", 1);
        romeMap.put("V", 5);
        romeMap.put("X", 10);
        romeMap.put("L", 50);
        romeMap.put("C", 100);
        romeMap.put("D", 500);
        romeMap.put("M", 1000);
        romeMap.put("IV", 4);
        romeMap.put("IX", 9);
        romeMap.put("XL", 40);
        romeMap.put("XC", 90);
        romeMap.put("CD", 400);
        romeMap.put("CM", 900);
        priorityMap.put('I', 1);
        priorityMap.put('V', 2);
        priorityMap.put('X', 3);
        priorityMap.put('L', 4);
        priorityMap.put('C', 5);
        priorityMap.put('D', 6);
        priorityMap.put('M', 7);
        specialChar.add('I');
        specialChar.add('X');
        specialChar.add('C');
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (specialChar.contains(s.charAt(i)) && i != s.length() - 1) {
                if (priorityMap.get(s.charAt(i)) < priorityMap.get(s.charAt(i + 1))) {
                    sum += romeMap.get(s.charAt(i) + "" + s.charAt(i + 1));
                    System.out.println(s.charAt(i) + "" + s.charAt(i + 1));
                    i++;
                } else {
                    sum += romeMap.get(Character.toString(s.charAt(i)));

                }
            } else {
                sum += romeMap.get(Character.toString(s.charAt(i)));
            }
        }
        return sum;
    }
}
