/**
 * Created by dbaofd on 2021/01/23.
 */
public class HIndex {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
//    Memory Usage: 37.1 MB, less than 25.02% of Java online submissions for H-Index.
    public int[] quickSort(int[] a, int left, int right) {
        int i = 0, j = 0;
        int t;
        int pivot = 0;
        if (left < right) {//if there is no this judgement, we may come across index out of bounds exception,
            i = left;//cuz left >right is commonly exist in recursion,and sometimes left may be larger than length of array
            j = right;//and then, when we execute 'pivot=a[left]' code, exception happens.
            pivot = a[left];//set first left as pivot
        }
        while (i != j && (left < right)) {//we need to fulfill left<right judgement here, cuz we need to make sure
            //code in this while circulation run correctly,or it will come across array out of bounds exception during recursion.
            while (a[j] >= pivot && i < j) {//scan from right to left util find the number that is smaller than pivot
                j--;
            }
            while (a[i] <= pivot && i < j) {//scan from left to right until find the number that is bigger than pivot
                i++;
            }
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        if (left < right) {
            a[left] = a[i];
            a[i] = pivot;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
        return a;
    }

    public int hIndex(int[] citations) {
        citations = quickSort(citations, 0, citations.length - 1);
        int hindex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                hindex = citations.length - i;
                break;
            }
        }
        return hindex;
    }
}
