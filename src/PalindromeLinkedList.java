/**
 * Created by dbaofd on 2020/9/12.
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> mynumber = new ArrayList();
        while (head != null) {
            mynumber.add(head.val);
            head = head.next;
        }
        boolean flag = true;
        for (int i = 0, j = mynumber.size() - 1; i < mynumber.size() / 2; i++, j--) {
            if ((mynumber.get(i) - mynumber.get(j)) != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
