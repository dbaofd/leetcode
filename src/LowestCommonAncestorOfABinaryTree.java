import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/12/28.
 */
public class LowestCommonAncestorOfABinaryTree {
//    Runtime: 7 ms, faster than 25.78% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
//    Memory Usage: 41.2 MB, less than 43.27% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    private class NodeInfo {
        private TreeNode parent;
        private int level;

        public NodeInfo(TreeNode parent, int level) {
            this.parent = parent;
            this.level = level;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    private Map<TreeNode, NodeInfo> myMap;

    private void inorderTraversal(TreeNode node, TreeNode parent, int level) {
        if (node != null) {
            inorderTraversal(node.left, node, level + 1);
            myMap.put(node, new NodeInfo(parent, level));
            inorderTraversal(node.right, node, level + 1);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        myMap = new HashMap<>();
        TreeNode lca = null;
        inorderTraversal(root, null, 1);
        NodeInfo pInfo = myMap.get(p);
        NodeInfo qInfo = myMap.get(q);
        if (pInfo.getLevel() == qInfo.getLevel()) {
            TreeNode parentP = pInfo.getParent();
            TreeNode parentQ = qInfo.getParent();
            while (parentP != parentQ) {
                parentP = myMap.get(parentP).getParent();
                parentQ = myMap.get(parentQ).getParent();
            }
            System.out.println(parentP.val);
            lca = parentP;
        } else if (pInfo.getLevel() > qInfo.getLevel()) {
            TreeNode parentP = pInfo.getParent();
            //Try to find p's parent that has the same level with q.
            while (myMap.get(parentP).getLevel() != qInfo.getLevel()) {
                parentP = myMap.get(parentP).getParent();
            }
            if (parentP == q) {//when they are at same level, check if they are the same node
                lca = q;
            } else {//now two nodes are at the same level
                parentP = myMap.get(parentP).getParent();
                TreeNode parentQ = qInfo.getParent();
                while (parentP != parentQ) {
                    parentP = myMap.get(parentP).getParent();
                    parentQ = myMap.get(parentQ).getParent();
                }
                lca = parentP;
            }
        } else if (pInfo.getLevel() < qInfo.getLevel()) {
            TreeNode parentQ = qInfo.getParent();
            while (myMap.get(parentQ).getLevel() != pInfo.getLevel()) {
                parentQ = myMap.get(parentQ).getParent();
            }
            if (parentQ == p) {//when they are at same level, check if they are the same node
                lca = p;
            } else {
                parentQ = myMap.get(parentQ).getParent();
                TreeNode parentP = pInfo.getParent();
                while (parentP != parentQ) {
                    parentP = myMap.get(parentP).getParent();
                    parentQ = myMap.get(parentQ).getParent();
                }
                lca = parentP;
            }
        }
        return lca;
    }
}
