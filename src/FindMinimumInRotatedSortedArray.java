/**
 * Created by dbaofd on 2020/12/01.
 */
public class FindMinimumInRotatedSortedArray {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
//    Memory Usage: 38.4 MB, less than 62.16% of Java online submissions for Find Minimum in Rotated Sorted Array.
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[0] > nums[i]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
