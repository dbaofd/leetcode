/**
 * Created by dbaofd on 2020/10/24.
 */
public class ConvertSortedArrayToBinarySearchTree {
    private void formSearchTree(int[] nums, int startIndex, int endIndex, int index, TreeNode node) {
        if (startIndex >= endIndex)
            return;
        if (startIndex < 0 || endIndex < 0)
            return;
        int leftChildIndex;
        if (index == 0)
            leftChildIndex = -1;
        else
            leftChildIndex = (startIndex + index - 1) / 2;
        int rightChildIndex = (index + endIndex + 2) / 2;
        if (node != null) {
            System.out.println(index + " " + startIndex + " " + endIndex);
            if (leftChildIndex >= startIndex && leftChildIndex <= endIndex) {
                TreeNode leftChild = new TreeNode(nums[leftChildIndex]);
                node.left = leftChild;
                formSearchTree(nums, startIndex, index - 1, leftChildIndex, leftChild);
            }
            if (rightChildIndex >= startIndex && rightChildIndex <= endIndex) {
                TreeNode rightChild = new TreeNode(nums[rightChildIndex]);
                node.right = rightChild;
                formSearchTree(nums, index + 1, endIndex, rightChildIndex, rightChild);
            }
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0], null, null);
        int rootIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        formSearchTree(nums, 0, nums.length - 1, rootIndex, root);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree a = new ConvertSortedArrayToBinarySearchTree();
        a.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    }
}
