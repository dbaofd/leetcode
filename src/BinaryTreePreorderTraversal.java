import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/11/16.
 */
public class BinaryTreePreorderTraversal {
    private void preorderTra(TreeNode root, List<Integer> printList) {
        if (root != null) {
            printList.add(root.val);
            preorderTra(root.left, printList);
            preorderTra(root.right, printList);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> printList = new ArrayList<>();
        preorderTra(root, printList);
        return printList;
    }
}
