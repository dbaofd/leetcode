/**
 * Created by dbaofd on 2021/01/22.
 */
public class MissingNumber {
//    Runtime: 1 ms, faster than 46.43% of Java online submissions for Missing Number.
//    Memory Usage: 39.6 MB, less than 45.57% of Java online submissions for Missing Number.
    public int missingNumber(int[] nums) {
        int[] myArray = new int[nums.length + 1];
        int missingNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            myArray[nums[i]] = 1;
        }
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == 0) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }
}
