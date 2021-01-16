import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dbaofd on 2021/01/17.
 */
public class MajorityElementII {
//    Runtime: 9 ms, faster than 22.70% of Java online submissions for Majority Element II.
//    Memory Usage: 42 MB, less than 86.61% of Java online submissions for Majority Element II.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> myList = new ArrayList<>();
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                int value = myMap.get(nums[i]);
                myMap.put(nums[i], value + 1);
            } else {
                myMap.put(nums[i], 1);
            }
        }
        int n = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() > n) {
                myList.add(entry.getKey());
            }
        }
        return myList;
    }
}
