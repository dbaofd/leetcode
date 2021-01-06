import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2021/01/07.
 */
public class BinaryTreePaths {
    private void inorderTraversal(TreeNode node, List<String> pathList, String path) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                path = path + node.val;
                pathList.add(path);
            } else if (node.left == null) {
                path = path + node.val + "->";
                inorderTraversal(node.right, pathList, path);
            } else if (node.right == null) {
                path = path + node.val + "->";
                inorderTraversal(node.left, pathList, path);
            } else {
                path = path + node.val + "->";
                inorderTraversal(node.left, pathList, path);
                inorderTraversal(node.right, pathList, path);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        String path = "";
        inorderTraversal(root, pathList, path);
        return pathList;
    }
}
