/**
 * Created by dbaofd on 2020/10/6.
 */
public class SortColors {
    //Runtime: 1 ms, faster than 13.60% of Java online submissions for Sort Colors.
    //Memory Usage: 37.3 MB, less than 98.67% of Java online submissions for Sort Colors.
    public void sortColors(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            int t = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[t] < nums[j]) {
                    temp = nums[t];
                    nums[t] = nums[j];
                    nums[j] = temp;
                    t = j;
                }
            }
        }
    }
}
