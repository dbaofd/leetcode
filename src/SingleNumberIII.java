import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2021/01/21.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                myMap.put(nums[i], myMap.get(nums[i]) + 1);
            } else {
                myMap.put(nums[i], 1);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() == 1) {
                answer[index] = entry.getKey();
                index++;
                if (index == 3)
                    break;
                ;
            }
        }
        return answer;
    }
}
