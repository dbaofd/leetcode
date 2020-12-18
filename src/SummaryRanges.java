import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/12/18.
 */
public class SummaryRanges {
//    Runtime: 6 ms, faster than 63.19% of Java online submissions for Summary Ranges.
//    Memory Usage: 37.4 MB, less than 50.18% of Java online submissions for Summary Ranges.
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        } else if (nums.length == 1) {
            results.add("" + nums[0]);
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                end = nums[i + 1];
                if (i + 1 == nums.length - 1) {
                    results.add(start + "->" + end);
                }
            } else {
                if (start != end) {
                    results.add(start + "->" + end);
                } else {
                    results.add("" + start);
                }
                start = nums[i + 1];
                end = nums[i + 1];
                if (i + 1 == nums.length - 1) {
                    results.add("" + start);
                }
            }
        }
        return results;
    }
}
