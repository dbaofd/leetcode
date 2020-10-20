import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    //    Runtime: 1 ms, faster than 75.26% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
//    Memory Usage: 38.9 MB, less than 36.09% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        int count = 1;
        for (List<Integer> li : myList) {
            if (count % 2 == 0) {//change the direction.
                for (int i = 0, j = li.size() - 1; i < li.size() / 2; i++, j--) {
                    int temp = li.get(i);
                    li.set(i, li.get(j));
                    li.set(j, temp);
                }
            }
            count++;
        }
        return myList;
    }
}
