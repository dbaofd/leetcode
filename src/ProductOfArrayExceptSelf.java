/**
 * Created by dbaofd on 2021/01/16.
 */
public class ProductOfArrayExceptSelf {
//    Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
//    Memory Usage: 49.9 MB, less than 59.39% of Java online submissions for Product of Array Except Self.
    public int[] productExceptSelf(int[] nums) {
        int productOfAll = 1;
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productOfAll *= nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                results[j] = productOfAll / nums[j];
            } else {
                int partialProduct = 1;
                for (int k = 0; k < nums.length; k++) {
                    if (j != k) {
                        partialProduct *= nums[k];
                    }
                }
                results[j] = partialProduct;
            }
        }
        return results;
    }
}
