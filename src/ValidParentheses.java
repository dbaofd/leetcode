/**
 * Created by dbaofd on 2020/9/12.
 */

import java.util.*;

public class ValidParentheses {
    //special test cases "{","}","{[]"
    public boolean isValid(String s) {
        boolean flag = true;
        Stack<Character> myStack = new Stack<>();
        Map<Character, Character> startBracket = new HashMap<>();
        startBracket.put('(', ')');
        startBracket.put('{', '}');
        startBracket.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            if (startBracket.containsKey(s.charAt(i))) {
                myStack.push(startBracket.get(s.charAt(i)));
            } else {
                if (myStack.size() != 0) {
                    if (myStack.pop() != s.charAt(i)) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (myStack.size() != 0) {
            flag = false;
        }
        return flag;
    }
}
