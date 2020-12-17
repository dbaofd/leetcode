/**
 * Created by dbaofd on 2020/12/17.
 */
public class InvertBinaryTree {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
//    Memory Usage: 38.4 MB, less than 5.34% of Java online submissions for Invert Binary Tree.
    private void invert(TreeNode node) {
        if (node != null) {
            TreeNode temp;
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            invert(node.left);
            invert(node.right);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
