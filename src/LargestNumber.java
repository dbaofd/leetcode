/**
 * Created by dbaofd on 2020/12/10.
 */
public class LargestNumber {
    //return true if a has higher priority.
    //8 vs 883
    private boolean comparePriority(int a, int b) {
        String stra = String.valueOf(a);
        String strb = String.valueOf(b);
        if (stra.charAt(0) > strb.charAt(0)) {
            return true;
        } else if (stra.charAt(0) < strb.charAt(0)) {
            return false;
        } else {
            if (stra.length() == strb.length()) {
                if (stra.length() == 1) {
                    return true;
                }
                for (int i = 1; i < stra.length(); i++) {
                    if (stra.charAt(i) > strb.charAt(i)) {
                        return true;
                    } else if (stra.charAt(i) < strb.charAt(i)) {
                        return false;
                    }
                }
            } else {
                int ab = Integer.parseInt(stra + strb);
                int ba = Integer.parseInt(strb + stra);
                if (ab >= ba) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //Special case [34323,3432], i got failed, last 3 in 34323 should be larger than all the digits in 3432
    //My previous algorithm will think 34323 has higher priority.
    //The truth is 3432 has higher priority.
    //Special case [0,0], return 0 rather than 00.
    public String largestNumber(int[] nums) {
        boolean isAllZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero)
            return "0";
        int temp;
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (comparePriority(nums[j], nums[j + 1])) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int k = nums.length - 1; k >= 0; k--) {
            result = result + nums[k];
        }
        return result;
    }
}
