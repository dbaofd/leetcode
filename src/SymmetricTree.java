import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by dbaofd on 2020/10/9.
 */
public class SymmetricTree {
    private boolean symmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        else if (a == null || b == null)
            return false;
        return (a.val == b.val) && symmetric(a.left, b.right) && symmetric(a.right, b.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetric(root.right, root.left);
    }
}
