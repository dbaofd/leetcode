import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/12/08.
 */
public class BSTIterator {
    private int pointer;
    private List<TreeNode> nodeList;

    public BSTIterator(TreeNode root) {
        nodeList = new ArrayList<>();
        inorderTraversal(root);
        pointer = -1;
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            nodeList.add(node);
            inorderTraversal(node.right);
        }
    }

    public int next() {
        pointer++;
        return nodeList.get(pointer).val;
    }

    public boolean hasNext() {
        if (pointer + 1 <= nodeList.size() - 1)
            return true;
        else
            return false;
    }
}
