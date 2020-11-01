/**
 * Created by dbaofd on 2020/11/01.
 */
public class BalancedBinaryTree {
    private boolean isBalanced = true;

    private int subtreeHeight(TreeNode node) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node != null) {
            leftHeight = 1 + subtreeHeight(node.left);
            rightHeight = 1 + subtreeHeight(node.right);
        } else {
            return 0;
        }
        if (Math.abs(leftHeight - rightHeight) > 1)
            isBalanced = false;
        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        subtreeHeight(root);
        return isBalanced;
    }
}
