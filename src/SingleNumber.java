import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();
        mySet.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                mySet.remove(nums[i]);
            } else {
                mySet.add(nums[i]);
            }
        }
        int result = 0;
        for (Integer a : mySet) {
            result = a;
        }
        return result;

    }
}
