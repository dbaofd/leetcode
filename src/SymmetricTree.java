import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dbaofd on 2020/10/9.
 */
//method two refer to https://zhuanlan.zhihu.com/p/249196445
//I am a bit confused about method one, it compares each sub tree's value to see if they are equal or not.
//The tree example in above link is symmetric, but by using method one, it fails to recognize it as symmetric tree.
public class SymmetricTree {
    //method one
    private boolean symmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        else if (a == null || b == null)
            return false;
        return (a.val == b.val) && symmetric(a.left, b.right) && symmetric(a.right, b.left);
    }

    private void preOrder(TreeNode root, List<Integer> li) {
        if (root != null) {
            li.add(root.val);
            preOrder(root.left, li);
            preOrder(root.right, li);
        } else {
            li.add(null);
        }
    }

    private void postOrder(TreeNode root, List<Integer> li) {
        if (root != null) {
            postOrder(root.left, li);
            postOrder(root.right, li);
            li.add(root.val);
        } else {
            li.add(null);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        //method one
//        if (root == null)
//            return true;
//        return symmetric(root.right, root.left);
        //method one end
        if (root == null)
            return true;
        if (root != null && root.left == null && root.right == null)
            return true;
        if (root != null && (root.left == null || root.right == null))
            return false;
        List<Integer> preorderListForLeftChild = new ArrayList<>();
        List<Integer> postorderListForRightChild = new ArrayList<>();
        if (root != null) {
            preOrder(root.left, preorderListForLeftChild);
            postOrder(root.right, postorderListForRightChild);
        }
        if (preorderListForLeftChild.size() != postorderListForRightChild.size())
            return false;
        else {
            int size = preorderListForLeftChild.size();
            for (int i = 0; i < size; i++) {
                if (preorderListForLeftChild.get(i) != postorderListForRightChild.get(size - 1 - i))
                    return false;
            }
        }
        return true;

    }
}
