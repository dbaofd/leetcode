import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/11/11.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> linkedListAMap = new HashMap<>();
        while (headA != null) {
            linkedListAMap.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (linkedListAMap.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
