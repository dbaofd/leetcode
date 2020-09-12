/**
 * Created by dbaofd on 2020/9/12.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addon = 0;
        int value;
        ListNode result = new ListNode();
        ListNode headOfResult = result;
        while (l1 != null || l2 != null || addon != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += addon;
            addon = sum / 10;
            value = sum % 10;
            ListNode temp = new ListNode();
            temp.val = value;
            result.next = temp;
            result = temp;
        }
        return headOfResult.next;
    }
}
