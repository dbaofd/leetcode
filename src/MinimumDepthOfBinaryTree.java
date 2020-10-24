import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/25.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        LinkedList<Integer> levelIndexQueue = new LinkedList<>();
        myQueue.offer(root);
        levelIndexQueue.offer(1);
        int minimumDepth = -1;
        while (!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            int levelIndex = levelIndexQueue.poll();
            int count = 0;
            if (node.left != null) {
                myQueue.offer(node.left);
                levelIndexQueue.offer(levelIndex + 1);
                count++;
            }
            if (node.right != null) {
                myQueue.offer(node.right);
                levelIndexQueue.offer(levelIndex + 1);
                count++;
            }
            if (count == 0) {//means this node is a leaf node.
                if (minimumDepth == -1) {
                    minimumDepth = levelIndex;
                } else if (minimumDepth > levelIndex) {
                    minimumDepth = levelIndex;
                }
            }

        }
        return minimumDepth;
    }
}
