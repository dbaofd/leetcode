import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/10.
 */
public class BinaryTreeInorderTraversal {
    private void inorderTra(TreeNode root, List<Integer> printList) {
        if (root != null) {
            inorderTra(root.left, printList);
            printList.add(root.val);
            inorderTra(root.right, printList);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> printList = new ArrayList<>();
        inorderTra(root, printList);
        return printList;
    }
}
