import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dbaofd on 2020/9/16.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> numberLetterMap = new HashMap<>();
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        List<String> myList;
        List<String> resultList = new ArrayList<>();
        int numOfElements;
        int currentLetterIndex = 0;
        for (int i = 2; i < 10; i++) {
            int j;
            myList = new ArrayList<>();
            if (i == 7 || i == 9) {
                numOfElements = 4;
            } else {
                numOfElements = 3;
            }
            for (j = currentLetterIndex; j < currentLetterIndex + numOfElements; j++) {
                myList.add(letters[j]);
            }
            numberLetterMap.put(String.valueOf(i).charAt(0), myList);
            currentLetterIndex = j;
        }
        if (digits.length() >= 2) {
            resultList = combineTwoList(numberLetterMap.get(digits.charAt(0)), numberLetterMap.get(digits.charAt(1)));
            for (int i = 2; i < digits.length(); i++) {
                resultList = combineTwoList(resultList, numberLetterMap.get(digits.charAt(i)));
            }
        } else if (digits.length() == 1) {
            resultList = numberLetterMap.get(digits.charAt(0));
        }
        return resultList;
    }

    List<String> combineTwoList(List<String> A, List<String> B) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                resultList.add(A.get(i) + B.get(j));
            }
        }
        return resultList;
    }
}
