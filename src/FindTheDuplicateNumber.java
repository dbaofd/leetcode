/**
 * Created by dbaofd on 2021/02/01.
 */
public class FindTheDuplicateNumber {
//    Runtime: 2 ms, faster than 51.74% of Java online submissions for Find the Duplicate Number.
//    Memory Usage: 41.7 MB, less than 6.23% of Java online submissions for Find the Duplicate Number.
    public int findDuplicate(int[] nums) {
        int[] a = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a[nums[i]] == 0) {
                a[nums[i]] = 1;
            } else {
                result = nums[i];
            }
        }
        return result;
    }
}
