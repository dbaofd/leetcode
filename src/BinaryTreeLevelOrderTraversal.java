import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> myList = new ArrayList<>();
        if (root == null)
            return myList;
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        LinkedList<Integer> levelIndexQueue = new LinkedList<>();
        myQueue.offer(root);
        levelIndexQueue.offer(1);
        List<Integer> levelNodeList = new ArrayList<>();
        levelNodeList.add(root.val);
        myList.add(levelNodeList);
        while (myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            int levelIndex = levelIndexQueue.poll();
            if (levelIndex != 1) {
                if (myList.size() != levelIndex) {
                    List<Integer> newLevelNodeList = new ArrayList<>();
                    newLevelNodeList.add(node.val);
                    myList.add(newLevelNodeList);
                } else {
                    myList.get(levelIndex - 1).add(node.val);
                }
            }
            if (node.left != null) {
                myQueue.offer(node.left);
                levelIndexQueue.offer(levelIndex + 1);
            }
            if (node.right != null) {
                myQueue.offer(node.right);
                levelIndexQueue.offer(levelIndex + 1);
            }
        }
        return myList;
    }
}
