import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/27.
 */
public class ConvertSortedListToBinarySearchTree {
    private void formSearchTree(List<Integer> nums, int startIndex, int endIndex, int index, TreeNode node) {
        if (startIndex >= endIndex)
            return;
        if (startIndex < 0 || endIndex < 0)
            return;
        int leftChildIndex;
        if (index == 0)
            leftChildIndex = -1;
        else
            leftChildIndex = (startIndex + index - 1) / 2;
        int rightChildIndex = (index + endIndex + 2) / 2;
        if (node != null) {
            if (leftChildIndex >= startIndex && leftChildIndex <= endIndex) {
                TreeNode leftChild = new TreeNode(nums.get(leftChildIndex));
                node.left = leftChild;
                formSearchTree(nums, startIndex, index - 1, leftChildIndex, leftChild);
            }
            if (rightChildIndex >= startIndex && rightChildIndex <= endIndex) {
                TreeNode rightChild = new TreeNode(nums.get(rightChildIndex));
                node.right = rightChild;
                formSearchTree(nums, index + 1, endIndex, rightChildIndex, rightChild);
            }
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> li = new ArrayList<>();
        while (head != null) {
            li.add(head.val);
            head = head.next;
        }
        if (li.size() == 0)
            return null;
        if (li.size() == 1)
            return new TreeNode(li.get(0), null, null);
        int rootIndex = li.size() / 2;
        TreeNode root = new TreeNode(li.get(rootIndex));
        formSearchTree(li, 0, li.size() - 1, rootIndex, root);
        return root;
    }
}
