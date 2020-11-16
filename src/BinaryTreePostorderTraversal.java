import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/11/17.
 */
public class BinaryTreePostorderTraversal {
    private void postorderTra(TreeNode node, List<Integer> myList) {
        if (node != null) {
            postorderTra(node.left, myList);
            postorderTra(node.right, myList);
            myList.add(node.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> printList = new ArrayList<>();
        postorderTra(root, printList);
        return printList;
    }
}
