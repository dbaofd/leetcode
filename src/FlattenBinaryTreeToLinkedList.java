import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/28.
 */
public class FlattenBinaryTreeToLinkedList {
    public void preorderTraversal(List<Integer> li, TreeNode node) {
        if (node != null) {
            li.add(node.val);
            preorderTraversal(li, node.left);
            preorderTraversal(li, node.right);
        }
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        List<Integer> myList = new ArrayList<>();
        preorderTraversal(myList, root);
        TreeNode newRoot = new TreeNode(root.val);
        TreeNode currentNode = newRoot;
        for (int i = 1; i < myList.size(); i++) {
            currentNode.right = new TreeNode(myList.get(i));
            currentNode = currentNode.right;
        }
        root.right = newRoot.right;
        root.left = null;
    }
}
