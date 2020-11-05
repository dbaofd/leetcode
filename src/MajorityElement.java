import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/11/06.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                myMap.put(nums[i], myMap.get(nums[i]) + 1);
            } else {
                myMap.put(nums[i], 1);
            }
        }
        int maxKey = 0;
        for (Integer key : myMap.keySet()) {
            if (myMap.get(key) > (nums.length / 2)) {
                maxKey = key;
                break;
            }
        }
        return maxKey;
    }
}
