import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/5.
 */
public class PartitionList {
    //Special case [2,1],2/[3,1,2],3/[1,1],2
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
    //Memory Usage: 38.8 MB, less than 81.91% of Java online submissions for Partition List.
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode newListHead = head;
        ListNode previousNode = head;
        ListNode currentSmallerNode = head;
        int currentNodeIndex = 0;
        while (head != null) {
            if (head.val < x) {
                if (currentNodeIndex != 0) {
                    if (previousNode.val < x) {
                        currentSmallerNode = head;
                    } else {
                        previousNode.next = head.next;
                        if (currentSmallerNode.val >= x) {
                            head.next = currentSmallerNode;
                            currentSmallerNode = head;
                            newListHead = head;
                        } else {
                            head.next = currentSmallerNode.next;
                            currentSmallerNode.next = head;
                            currentSmallerNode = head;
                        }
                        head = previousNode;
                    }
                }
            }
            previousNode = head;
            if (head != null) {
                head = head.next;
            }
            currentNodeIndex++;
        }
        return newListHead;
    }
}
