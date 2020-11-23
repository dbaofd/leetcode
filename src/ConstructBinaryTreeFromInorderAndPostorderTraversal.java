/**
 * Created by dbaofd on 2020/11/23.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private void solveRecursively(TreeNode node, int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder) {
        if (inStart == inEnd) {
            node.left = null;
            node.right = null;
            return;
        }
        int nodeIndexOfInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                nodeIndexOfInorder = i;
                break;
            }
        }
        if (nodeIndexOfInorder > inStart && nodeIndexOfInorder < inEnd) {
            int leftTreeSize = nodeIndexOfInorder - inStart;
            TreeNode leftChild = new TreeNode(postorder[postStart + leftTreeSize - 1]);
            TreeNode rightChild = new TreeNode(postorder[postEnd - 1]);
            node.left = leftChild;
            node.right = rightChild;
            solveRecursively(leftChild, inStart, nodeIndexOfInorder - 1, postStart, postStart + leftTreeSize - 1, inorder, postorder);
            solveRecursively(rightChild, nodeIndexOfInorder + 1, inEnd, postStart + leftTreeSize, postEnd - 1, inorder, postorder);
        } else if (nodeIndexOfInorder == inEnd) {
            TreeNode leftChild = new TreeNode(postorder[postEnd - 1]);
            node.left = leftChild;
            solveRecursively(leftChild, inStart, inEnd - 1, postStart, postEnd - 1, inorder, postorder);
        } else {//nodeIndexOfInorder=inStart
            TreeNode rightChild = new TreeNode(postorder[postEnd - 1]);
            node.right = rightChild;
            solveRecursively(rightChild, inStart + 1, inEnd, postStart, postEnd - 1, inorder, postorder);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        solveRecursively(root, 0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
        return root;
    }
}
