/**
 * Created by dbaofd on 2020/9/19.
 */
public class RemoveDuplicatesFromSortedListII {
    //special cases [1,2,2],[1,1,1],[1],[1,1,2]
    public ListNode deleteDuplicates(ListNode head) {
        ListNode myHead = head;
        ListNode previousNode = null;
        ListNode prePreviousNode = null;
        int numOfValidedNode = 0;
        if (head == null)
            return null;
        if (head.next == null)
            return myHead;
        while (head != null) {
            if (previousNode == null) {
                previousNode = head;
            } else {
                boolean isDuplicated = false;
                while (head.val == previousNode.val) {
                    isDuplicated = true;
                    previousNode.next = head.next;
                    head = head.next;
                    if (head == null)
                        break;
                }
                if (head != null) {
                    if (isDuplicated) {
                        if (prePreviousNode == null) {
                            myHead = head;
                            previousNode = head;
                        } else {
                            prePreviousNode.next = head;
                            previousNode = head;
                        }
                    } else {
                        prePreviousNode = previousNode;
                        previousNode = head;
                        numOfValidedNode++;
                    }
                } else {//for [1,2,3,3,3]
                    if (isDuplicated) {
                        if (prePreviousNode == null) {
                            myHead = head;
                            previousNode = head;
                        } else {
                            prePreviousNode.next = head;
                            previousNode = head;
                        }
                    }
                }
            }
            if (head != null)
                head = head.next;
        }
        if (numOfValidedNode == 0 && previousNode == null) { //for [1,1,2]
            myHead = null;
        }
        return myHead;
    }
}
