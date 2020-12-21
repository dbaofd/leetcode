import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/12/22.
 */
public class KthSmallestElementInABST {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
//    Memory Usage: 39.4 MB, less than 25.81% of Java online submissions for Kth Smallest Element in a BST.
    private void inorderTraversal(TreeNode node, List<Integer> myList) {
        if (node != null) {
            inorderTraversal(node.left, myList);
            myList.add(node.val);
            inorderTraversal(node.right, myList);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> myList = new ArrayList<>();
        inorderTraversal(root, myList);
        return myList.get(k - 1);
    }
}
