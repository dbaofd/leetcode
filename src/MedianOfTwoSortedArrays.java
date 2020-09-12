/**
 * Created by dbaofd on 2020/9/12.
 */
public class MedianOfTwoSortedArrays {
    public double getAns(int[] m, int[] n, int flag) {
        int lenm = m.length;
        int lenn = n.length;
        int[] t = new int[lenm + lenn];
        int i = 0;
        int j = 0;
        int k = 0;
        double ans = 0;
        if (lenn != 0) {
            while (j < lenn && i < lenm) {
                if (m[i] <= n[j]) {
                    t[k] = m[i];
                    i++;
                    k++;
                } else {
                    t[k] = n[j];
                    j++;
                    k++;
                }
            }
            while (k < (lenm + lenn)) {
                if (i == lenm) {
                    t[k] = n[j];
                    k++;
                    j++;
                } else if (j == lenn) {
                    t[k] = m[i];
                    k++;
                    i++;
                }
            }
            if (t.length % 2 == 0) {//m and n have same length
                ans = ((double) t[(lenm + lenn) / 2 - 1] + (double) t[(lenm + lenn) / 2]) / 2;
            } else {
                ans = (double) t[(lenm + lenn) / 2];
            }
            for (int y = 0; y < t.length; y++) {
                System.out.println(t[y]);
            }
        } else {
            if (lenm % 2 == 1) {
                ans = (double) m[lenm / 2];
            } else {
                ans = ((double) m[lenm / 2] + (double) m[lenm / 2 - 1]) / 2;
            }
        }
        return ans;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double ans = 0;
        if (len1 > len2) {
            ans = getAns(nums1, nums2, 0);
        } else if (len1 < len2) {
            ans = getAns(nums2, nums1, 0);
        } else {
            ans = getAns(nums1, nums2, 1);
        }
        return ans;
    }
}
