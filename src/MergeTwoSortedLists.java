/**
 * Created by dbaofd on 2020/9/12.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode headOfResult = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    result.next = l1;
                    l1 = l1.next;
                    result = result.next;
                } else {
                    result.next = l2;
                    l2 = l2.next;
                    result = result.next;
                }
            } else if (l1 != null && l2 == null) {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }
        result.next = null;
        return headOfResult.next;
    }
}
