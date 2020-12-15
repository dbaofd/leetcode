import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/12/16.
 */
public class ContainsDuplicateII {
//    Runtime: 5 ms, faster than 90.48% of Java online submissions for Contains Duplicate II.
//    Memory Usage: 45.1 MB, less than 17.64% of Java online submissions for Contains Duplicate II.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> myMap = new HashMap();
        myMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (myMap.containsKey(nums[i]))
                if (Math.abs(myMap.get(nums[i]) - i) <= k)
                    return true;
                else
                    myMap.put(nums[i], i);//update value
            else
                myMap.put(nums[i], i);
        }
        return false;
    }
}
