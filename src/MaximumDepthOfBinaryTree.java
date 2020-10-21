public class MaximumDepthOfBinaryTree {
    private int preorderTraversal(TreeNode node, int previousDepth) {
        int left = 0, right = 0;
        int count = 0;
        if (node != null) {
            System.out.println(node.val);
            if (node.left != null) {
                count++;
                left = preorderTraversal(node.left, previousDepth + 1);
            }
            if (node.right != null) {
                count++;
                right = preorderTraversal(node.right, previousDepth + 1);
            }
            if (count == 2)
                return Math.max(left, right);
            else if (count == 0)
                return previousDepth;
            else if (node.left != null) {
                return left;
            } else {
                return right;
            }
        }
        return previousDepth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return preorderTraversal(root, 1);
    }
}
