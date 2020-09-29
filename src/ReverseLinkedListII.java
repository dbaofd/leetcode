import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/9/29.
 */
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
//Memory Usage: 36.5 MB, less than 99.66% of Java online submissions for Reverse Linked
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode result = head;
        List<ListNode> nodesToBeReversed = new ArrayList<>();
        int count = 1;
        ListNode storagedNode;
        while (head != null) {
            if (count > n)
                break;
            if (count >= m && count <= n) {//if m=2,n=4, then put node 2,3,4 into the list.
                storagedNode = head;
                nodesToBeReversed.add(storagedNode);
            }
            count++;
            head = head.next;
        }
        //Exchange the value in the list, node 2 and node 4 exchange value, node 3 remain the same.
        for (int i = 0, j = nodesToBeReversed.size() - 1; i < nodesToBeReversed.size() / 2; i++, j--) {
            int temp = nodesToBeReversed.get(i).val;
            nodesToBeReversed.get(i).val = nodesToBeReversed.get(j).val;
            nodesToBeReversed.get(j).val = temp;
        }
        return result;
    }
}
