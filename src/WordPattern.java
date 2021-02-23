import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2021/02/23.
 */
public class WordPattern {
//    Runtime: 1 ms, faster than 82.71% of Java online submissions for Word Pattern.
//    Memory Usage: 38.6 MB, less than 12.06% of Java online submissions for Word Pattern.
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> myMap1 = new HashMap<>();
        Map<String, Character> myMap2 = new HashMap<>();
        String[] strArr = s.split(" ");
        if (strArr.length != pattern.length()) {
            return false;
        }
        Character[] ch = new Character[pattern.length()];
        for (int i = 0; i < pattern.length(); i++) {
            ch[i] = pattern.charAt(i);
        }
        for (int i = 0; i < strArr.length; i++) {
            if (myMap1.containsKey(ch[i])) {
                if (!myMap1.get(ch[i]).equals(strArr[i]))
                    return false;
            } else if (myMap2.containsKey(strArr[i])) {//consider this case "abba" "dog dog dog dog"
                return false;
            } else {
                myMap1.put(ch[i], strArr[i]);
                myMap2.put(strArr[i], ch[i]);
            }
        }
        return true;
    }
}
