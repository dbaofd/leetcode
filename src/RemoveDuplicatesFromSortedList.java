/**
 * Created by dbaofd on 2020/9/18.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode myHead = head;
        ListNode previousNode = null;
        while (head != null) {
            if (previousNode == null) {
                previousNode = head;
            } else {
                while (head.val == previousNode.val) {
                    previousNode.next = head.next;
                    head = head.next;
                    if (head == null)
                        break;
                }
                if (head != null)
                    previousNode = head;
            }
            if (head != null)
                head = head.next;
        }
        return myHead;
    }
}
