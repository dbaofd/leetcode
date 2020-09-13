/**
 * Created by dbaofd on 2020/9/13.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int reallen = len;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int t = i;
            while (j < reallen && nums[j] == val) {
                j++;
                len--;
            }
            if (j != i) {
                for (int k = j; k < reallen; k++) {
                    nums[t] = nums[k];
                    t++;
                }
            }
            reallen = len;
        }
        return len;
    }
}
