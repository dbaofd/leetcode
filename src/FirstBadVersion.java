/**
 * Created by dbaofd on 2021/01/31.
 */
public class FirstBadVersion {
    // isBadversion is provided by leetcode
//    Runtime: 12 ms, faster than 98.06% of Java online submissions for First Bad Version.
//    Memory Usage: 35.5 MB, less than 90.87% of Java online submissions for First Bad Version.
    private boolean isBadVersion(int a) {
        return false;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int result = 0;
        while (end - start > 1) {
            if (isBadVersion(start + (end - start + 1) / 2)) {
                end = start + (end - start + 1) / 2;
            } else {
                start = start + (end - start + 1) / 2 + 1;
            }
        }
        if (end == start)
            result = start;
        else {
            if (isBadVersion(start))
                result = start;
            else
                result = end;
        }
        return result;
    }
}
