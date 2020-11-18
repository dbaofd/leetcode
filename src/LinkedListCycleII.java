import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/11/18.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        Map<ListNode, Integer> myMap = new HashMap<>();
        while (head != null) {
            myMap.put(head, 1);
            if (myMap.containsKey(head.next))
                return head.next;
            head = head.next;
        }
        return null;
    }
}
