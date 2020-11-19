import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/11/19.
 */
public class SumRootToLeafNumbers {
//    Runtime: 1 ms, faster than 26.47% of Java online submissions for Sum Root to Leaf Numbers.
//    Memory Usage: 36.5 MB, less than 73.79% of Java online submissions for Sum Root to Leaf Numbers.
    private void preorderTraversal(TreeNode node, List<Integer> path, List<Integer> pathSumList) {
        path.add(node.val);
        if (node.left != null && node.right != null) {
            List<Integer> pathCopy = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                pathCopy.add(path.get(i));
            }
            preorderTraversal(node.left, path, pathSumList);
            preorderTraversal(node.right, pathCopy, pathSumList);
        } else if (node.left != null) {
            preorderTraversal(node.left, path, pathSumList);
        } else if (node.right != null) {
            preorderTraversal(node.right, path, pathSumList);
        } else {
            int a = 1;
            int sum = 0;
            for (int j = path.size() - 1; j >= 0; j--) {
                sum += a * path.get(j);
                a *= 10;
            }
            pathSumList.add(sum);
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        List<Integer> path = new ArrayList<>();
        List<Integer> pathSumList = new ArrayList<>();
        preorderTraversal(root, path, pathSumList);
        int sum = 0;
        for (int i = 0; i < pathSumList.size(); i++) {
            sum += pathSumList.get(i);
        }
        return sum;
    }
}
