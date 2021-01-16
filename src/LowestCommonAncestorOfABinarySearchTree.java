/**
 * Created by dbaofd on 2021/01/09.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (p.val < node.val && q.val > node.val) {
            return node;
        } else if (p.val > node.val && q.val < node.val) {
            return node;
        } else if (p.val == node.val) {
            return p;
        } else if (q.val == node.val) {
            return q;
        } else if (p.val < node.val && q.val < node.val) {
            return findLCA(node.left, p, q);
        }
        return findLCA(node.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = findLCA(root, p, q);
        return result;
    }
}

