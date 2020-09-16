import java.util.*;

/**
 * Created by dbaofd on 2020/9/16.
 */
public class GroupAnagrams {
    // passed all 112 tests, but took too much time. Low efficiency.
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> resultGroupList = new ArrayList<>();
        List<String> myGroup;
        Map<String, Map<Character, Integer>> wordMap = new HashMap<>();
        Map<Character, Integer> letterMap;
        for (int i = 0; i < strs.length; i++) {
            letterMap = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                if (letterMap.containsKey(strs[i].charAt(j))) {
                    int letterFrequency = letterMap.get(strs[i].charAt(j)) + 1;
                    letterMap.put(strs[i].charAt(j), letterFrequency);
                } else {
                    letterMap.put(strs[i].charAt(j), 1);
                }
            }
            wordMap.put(strs[i], letterMap);//each word has a letterMap to store the frequency of each letter.
        }
        if (strs.length != 0) {//creat the first group.
            myGroup = new ArrayList<>();
            myGroup.add(strs[0]);
            resultGroupList.add(myGroup);
        }
        Map<Character, Integer> letterMapOfFisrtGroupWord;
        Map<Character, Integer> letterMapOfCurrentWord;
        for (int i = 1; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < resultGroupList.size(); j++) {//to see if this word can be classified into any existing group.
                String fisrtGroupWord = resultGroupList.get(j).get(0);
                letterMapOfFisrtGroupWord = wordMap.get(fisrtGroupWord);
                letterMapOfCurrentWord = wordMap.get(strs[i]);
                if (letterMapOfFisrtGroupWord.equals(letterMapOfCurrentWord)) {//to see if this word is the anagram of this group.
                    resultGroupList.get(j).add(strs[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {//The word cannot be classified into any existing group, then creat new group.
                myGroup = new ArrayList<>();
                myGroup.add(strs[i]);
                resultGroupList.add(myGroup);
            }
        }
        return resultGroupList;
    }

    //After checking the discussion, we need to use char_to_array, then sort the char array.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> myMap = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            if (myMap.containsKey(key)) {
                List<String> group = myMap.get(key);
                group.add(s);
                myMap.put(key, group);
            } else {
                List<String> group = new ArrayList<>();
                group.add(s);
                myMap.put(key, group);
            }
        }
        for (List<String> group : myMap.values()) {
            resultList.add(group);
        }
        return resultList;
    }

}
