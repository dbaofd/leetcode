import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/11/15.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        Map<ListNode, Integer> myMap = new HashMap<>();
        while (head != null) {
            myMap.put(head, 1);
            if (myMap.containsKey(head.next))
                return true;
            head = head.next;
        }
        return false;
    }
}
