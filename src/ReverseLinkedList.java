import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/9/29.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        List<Integer> myList = new ArrayList<>();
        while (head != null) {
            myList.add(head.val);
            head = head.next;
        }
        ListNode myHead = new ListNode(myList.get(myList.size() - 1));
        ListNode result = myHead;
        for (int i = myList.size() - 2; i >= 0; i--) {
            myHead.next = new ListNode(myList.get(i));
            myHead = myHead.next;
        }
        myHead.next = null;
        return result;
    }
}
