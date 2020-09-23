import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/9/23.
 */
public class SameTree {
    public boolean isSame = true;

    public void preOrderTraverse(TreeNode node1, TreeNode node2) {
        int flag = 0;
        if (node1 != null)
            flag++;
        if (node2 != null)
            flag++;
        if (flag == 2) {
            if (node1.val == node2.val) {
                preOrderTraverse(node1.left, node2.left);
                preOrderTraverse(node1.right, node2.right);
            } else {
                isSame = false;
            }
        } else if (flag == 1) {
            isSame = false;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        preOrderTraverse(p, q);
        return isSame;
    }
}
