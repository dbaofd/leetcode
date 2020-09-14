/**
 * Created by dbaofd on 2020/9/14.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int ideaPositionIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ideaPositionIndex = i;
                break;
            } else if (nums[i] > target) {
                ideaPositionIndex = i;
                break;
            }
        }
        if (ideaPositionIndex == -1) {
            ideaPositionIndex = nums.length;
        }
        return ideaPositionIndex;
    }
}
