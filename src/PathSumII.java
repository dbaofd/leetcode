import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    //    Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
//    Memory Usage: 39.3 MB, less than 5.04% of Java online submissions for Path Sum II.
    private void preorderTraversal(TreeNode node, int sum, int currentSum, List<List<Integer>> finalListofList, List<Integer> currentList) {
        if (node != null) {
            currentList.add(node.val);
            currentSum += node.val;
            if (node.left != null && node.right != null) {
                List<Integer> leftList = new ArrayList<>();
                List<Integer> rightList = new ArrayList<>();
                for (Integer i : currentList) {
                    leftList.add(i);
                    rightList.add(i);
                }
                preorderTraversal(node.left, sum, currentSum, finalListofList, leftList);
                preorderTraversal(node.right, sum, currentSum, finalListofList, rightList);
            } else if (node.left != null) {
                preorderTraversal(node.left, sum, currentSum, finalListofList, currentList);
            } else {
                preorderTraversal(node.right, sum, currentSum, finalListofList, currentList);
            }
        } else {
            if (currentSum == sum)
                finalListofList.add(currentList);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> finalListofList = new ArrayList<>();
        if (root == null)
            return finalListofList;
        preorderTraversal(root, sum, 0, finalListofList, currentList);
        return finalListofList;
    }
}
