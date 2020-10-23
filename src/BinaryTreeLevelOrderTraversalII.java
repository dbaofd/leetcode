import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    //    Runtime: 1 ms, faster than 84.37% of Java online submissions for Binary Tree Level Order Traversal II.
//    Memory Usage: 39.2 MB, less than 12.94% of Java online submissions for Binary Tree Level Order Traversal II.
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        for (int i = 0, j = myList.size() - 1; i < myList.size() / 2; i++, j--) {
            List<Integer> temp = myList.get(i);
            myList.set(i, myList.get(j));
            myList.set(j, temp);
        }
        return myList;
    }
}
