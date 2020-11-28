/**
 * Created by dbaofd on 2020/11/28.
 */
public class KthLargestElementInAnArray {
    public int[] shellSort(int[] a) {
        int gap;
        for (gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    int temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                }
            }
        }
        return a;
    }

    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = shellSort(nums);
        return sortedArray[sortedArray.length - k];
    }
}
