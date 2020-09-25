/**
 * Created by dbaofd on 2020/9/25.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentNums2Index = 0;
        int currentNums1Index = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            flag = 0;
            currentNums2Index = i;
            for (int j = currentNums1Index; j < m; j++) {
                if (nums1[j] > nums2[i]) {
                    flag = 1;
                    for (int k = m; k > j; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[j] = nums2[i];
                    currentNums1Index = j;
                    break;
                }
                currentNums1Index = j;
            }
            if (flag == 1)
                m++;
            if (flag == 0)
                break;
        }
        if (currentNums2Index < n - 1) {
            for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[currentNums2Index];
                currentNums2Index++;
            }
        } else if (currentNums2Index == n - 1 && flag == 0) {
            for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[currentNums2Index];
                currentNums2Index++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}
