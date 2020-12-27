/**
 * Created by dbaofd on 2020/12/27.
 */
public class CountCompleteTreeNodes {
    private int numberOfTree;

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            numberOfTree++;
            inorderTraversal(node.right);
        }
    }

    public int countNodes(TreeNode root) {
        numberOfTree = 0;
        inorderTraversal(root);
        return numberOfTree;
    }
}
