/**
 * Created by dbaofd on 2021/02/07.
 */
public class MoveZeroes {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
//    Memory Usage: 39.5 MB, less than 41.64% of Java online submissions for Move Zeroes.
    public void moveZeroes(int[] nums) {
        int numOfZeros = 0;
        int indexPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZeros++;
            } else {
                nums[indexPointer++] = nums[i];
            }
        }
        while (numOfZeros != 0) {
            nums[indexPointer++] = 0;
            numOfZeros--;
        }
    }
}
