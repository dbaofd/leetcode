import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dbaofd on 2020/11/21.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //low efficiency
    private void solveRecursively(TreeNode node, List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.size() == 1) {
            node.left = null;
            node.right = null;
            return;
        }
        int nodeIndexOfInorder = -1;
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i) == node.val) {
                nodeIndexOfInorder = i;
                break;
            }
        }
        if (nodeIndexOfInorder > 0 && nodeIndexOfInorder < inorderList.size() - 1) {
            TreeNode leftChild = new TreeNode(preorderList.get(1));
            TreeNode rightChild = new TreeNode(preorderList.get(nodeIndexOfInorder + 1));
            node.left = leftChild;
            node.right = rightChild;
            List<Integer> leftPreorderList = new ArrayList<>();
            List<Integer> rightPreorderList = new ArrayList<>();
            for (int j = 1; j < preorderList.size(); j++) {
                if (j <= nodeIndexOfInorder) {
                    leftPreorderList.add(preorderList.get(j));
                } else {
                    rightPreorderList.add(preorderList.get(j));
                }
            }
            List<Integer> leftInorderList = new ArrayList<>();
            List<Integer> rightInorderList = new ArrayList<>();
            for (int k = 0; k < inorderList.size(); k++) {
                if (k >= 0 && k < nodeIndexOfInorder) {
                    leftInorderList.add(inorderList.get(k));
                } else if (k > nodeIndexOfInorder) {
                    rightInorderList.add(inorderList.get(k));
                }
            }
            solveRecursively(leftChild, leftPreorderList, leftInorderList);
            solveRecursively(rightChild, rightPreorderList, rightInorderList);
        } else if (nodeIndexOfInorder == inorderList.size() - 1) {
            TreeNode leftChild = new TreeNode(preorderList.get(1));
            node.left = leftChild;
            node.right = null;
            List<Integer> leftPreorderList = new ArrayList<>();
            for (int j = 1; j < preorderList.size(); j++) {
                leftPreorderList.add(preorderList.get(j));
            }
            List<Integer> leftInorderList = new ArrayList<>();
            for (int k = 0; k < inorderList.size() - 1; k++) {
                leftInorderList.add(inorderList.get(k));
            }
            solveRecursively(leftChild, leftPreorderList, leftInorderList);
        } else {//nodeIndexOfInorder=0
            TreeNode rightChild = new TreeNode(preorderList.get(nodeIndexOfInorder + 1));
            node.right = rightChild;
            node.left = null;
            List<Integer> rightPreorderList = new ArrayList<>();
            for (int j = 1; j < preorderList.size(); j++) {
                rightPreorderList.add(preorderList.get(j));
            }
            List<Integer> rightInorderList = new ArrayList<>();
            for (int k = 1; k < inorderList.size(); k++) {
                rightInorderList.add(inorderList.get(k));
            }
            solveRecursively(rightChild, rightPreorderList, rightInorderList);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        solveRecursively(root, preorderList, inorderList);
        return root;
    }
}
