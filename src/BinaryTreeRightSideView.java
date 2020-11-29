import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dbaofd on 2020/11/29.
 */
public class BinaryTreeRightSideView {
    //    Runtime: 1 ms, faster than 73.50% of Java online submissions for Binary Tree Right Side View.
    //    Memory Usage: 37.9 MB, less than 23.35% of Java online submissions for Binary Tree Right
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
        while (!myQueue.isEmpty()) {
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

    // Level order traversal will return a list of lists,
    // every list in the list contains elements from same level,
    // Right side view is the last(left to right) element in every level.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideList = new ArrayList<>();
        if (root == null)
            return rightSideList;
        List<List<Integer>> levelOrderList;
        levelOrderList = levelOrder(root);
        for (int i = 0; i < levelOrderList.size(); i++) {
            int size = levelOrderList.get(i).size();
            rightSideList.add(levelOrderList.get(i).get(size - 1));
        }
        return rightSideList;
    }
}
