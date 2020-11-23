import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dbaofd on 2020/11/21.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalApproachII {
//    Runtime: 3 ms, faster than 50.44% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
//    Memory Usage: 38.6 MB, less than 95.67% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    private void solveRecursively(TreeNode node, int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart == preEnd) {
            node.left = null;
            node.right = null;
            return;
        }
        int nodeIndexOfInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                nodeIndexOfInorder = i;
                break;
            }
        }
        if (nodeIndexOfInorder > inStart && nodeIndexOfInorder < inEnd) {
            int leftTreeSize = nodeIndexOfInorder - inStart;
            TreeNode leftChild = new TreeNode(preorder[preStart + 1]);
            TreeNode rightChild = new TreeNode(preorder[preStart + leftTreeSize + 1]);
            node.left = leftChild;
            node.right = rightChild;
            solveRecursively(leftChild, preStart + 1, preStart + leftTreeSize, inStart, nodeIndexOfInorder - 1, preorder, inorder);
            solveRecursively(rightChild, preStart + leftTreeSize + 1, preEnd, nodeIndexOfInorder + 1, inEnd, preorder, inorder);
        } else if (nodeIndexOfInorder == inEnd) {
            int leftTreeSize = nodeIndexOfInorder - inStart;
            TreeNode leftChild = new TreeNode(preorder[preStart + 1]);
            node.left = leftChild;
            node.right = null;
            solveRecursively(leftChild, preStart + 1, preEnd, inStart, inEnd - 1, preorder, inorder);
        } else {//nodeIndexOfInorder=inStart
            int rightTreeSize = inEnd - nodeIndexOfInorder;
            TreeNode rightChild = new TreeNode(preorder[preStart + 1]);
            node.right = rightChild;
            node.left = null;
            solveRecursively(rightChild, preStart + 1, preEnd, inStart + 1, inEnd, preorder, inorder);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        solveRecursively(root, 0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
        return root;
    }
}
