/**
 * Created by dbaofd on 2020/9/12.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        //special cases [1,1], [1,1,2,2] [1,1,2]
        int len = nums.length;
        int realLen = nums.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            int t = i;
            while (nums[i - 1] == nums[j]) {
                j++;
                len--;
                if (j > nums.length - 1) {//special case nums=[1,1]
                    //in this case, j will be 2, next loop to judge while condition
                    //nums[j] will have index out of bound error.
                    j--;
                    break;
                } else if (j > realLen - 1) {
                    break;
                }
            }
            realLen = len;
            if (j != i) {//j!=i means there are duplicated values between i-1 and j
                for (int k = j; k < nums.length; k++) {
                    nums[t] = nums[k];
                    t++;
                }
            }
        }
        return realLen;
    }
}
