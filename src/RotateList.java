import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/2.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        if (head == null)
            return null;
        ListNode listHead = head;
        ListNode listTail = new ListNode();
        int preListTailIndex = 0;
        List<ListNode> allNodes = new ArrayList<>();
        int nodeNum = 0;
        int realRotateStep;
        while (head != null) {
            allNodes.add(head);
            if (head.next == null) {
                listTail = head;
            } else {
                preListTailIndex = nodeNum;
            }
            head = head.next;
            nodeNum++;
        }
        realRotateStep = k % nodeNum;
        while (realRotateStep > 0) {
            allNodes.get(preListTailIndex).next = null;
            listTail.next = listHead;
            listHead = listTail;
            listTail = allNodes.get(preListTailIndex);
            if (preListTailIndex == 0) {
                preListTailIndex = allNodes.size() - 1;
            } else {
                preListTailIndex--;
            }
            realRotateStep--;
        }
        return listHead;
    }
}
