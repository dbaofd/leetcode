public class PathSum {
    //    Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
//    Memory Usage: 38.6 MB, less than 18.87% of Java online submissions for Path Sum.
    private boolean preorderTraversal(TreeNode node, int sum, int currentSum) {
        if (node != null) {
            currentSum += node.val;
            boolean leftResult;
            boolean rightResult;
            if (node.left != null && node.right != null) {
                leftResult = preorderTraversal(node.left, sum, currentSum);
                rightResult = preorderTraversal(node.right, sum, currentSum);
                if (leftResult || rightResult)
                    return true;
                else
                    return false;
            } else if (node.left != null) {
                leftResult = preorderTraversal(node.left, sum, currentSum);
                return leftResult;
            } else {
                rightResult = preorderTraversal(node.right, sum, currentSum);
                return rightResult;
            }
        } else {
            if (currentSum == sum)
                return true;
            else
                return false;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return preorderTraversal(root, sum, 0);
    }
}
