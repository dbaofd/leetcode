/**
 * Created by dbaofd on 2020/12/09.
 */
public class FindPeakElement {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
//    Memory Usage: 38.8 MB, less than 39.38% of Java online submissions for Find Peak Element.
    public int findPeakElement(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    result = i;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                result = i;
                break;
            }
        }
        return result;
    }
}
