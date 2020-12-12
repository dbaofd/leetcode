import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/12/13.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, Integer> myMap = new HashMap();
        myMap.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (myMap.containsKey(nums[i]))
                return true;
            else
                myMap.put(nums[i], 1);
        }
        return false;
    }
}
