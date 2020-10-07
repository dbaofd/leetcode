/**
 * Created by dbaofd on 2020/10/7.
 */
public class RemoveDuplicatesFromSortedArrayII {
    //Runtime: 1 ms, faster than 31.20% of Java online submissions for Remove Duplicates from Sorted Array II.
    //Memory Usage: 39 MB, less than 97.39% of Java online submissions for Remove Duplicates from Sorted Array II.
    public int removeDuplicates(int[] nums) {
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
            if (j - i >= 2) {//j!=i means there are duplicated values between i-1 and j
                t++;
                realLen = ++len;//extra one off, so need to add one. wo don't deal with two duplicated number
                for (int k = j; k < nums.length; k++) {
                    nums[t] = nums[k];
                    t++;
                }
            } else if (j - i == 1) {
                realLen = ++len;
            }
        }
        return realLen;
    }
}
