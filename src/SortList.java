/**
 * Created by dbaofd on 2020/11/14.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortList {
    //Time Limit Exceeded
    private void quickSort(List<ListNode> a, int left, int right) {
        int i = 0, j = 0;
        ListNode t;
        ListNode pivot = null;
        if (left < right) {
            i = left;
            j = right;
            pivot = a.get(left);//set first left as pivot
        }
        while (i != j && (left < right)) {
            while (a.get(j).val >= pivot.val && i < j) {//scan from right to left util find the number that is smaller than pivot
                j--;
            }
            while (a.get(i).val <= pivot.val && i < j) {//scan from left to right until find the number that is bigger than pivot
                i++;
            }
            if (i < j) {
                t = a.get(i);
                a.set(i, a.get(j));
                a.set(j, t);
            }
        }
        if (left < right) {
            a.set(left, a.get(i));
            a.set(i, pivot);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

    public ListNode sortList(ListNode head) {
        List<ListNode> myList = new ArrayList<>();
        if (head == null)
            return null;
        while (head != null) {
            myList.add(head);
            head = head.next;
        }
        quickSort(myList, 0, myList.size() - 1);
        ListNode node = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            System.out.println(myList.get(i).val);
            node.next = myList.get(i);
            node = node.next;
        }
        node.next = null;
        return myList.get(0);
    }
}
