import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/11.
 */
public class NAryTreePreorderTraversal {
    private void preorderTraversal(Node node, List<Integer> li) {
        if (node != null) {
            li.add(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                preorderTraversal(node.children.get(i), li);
            }
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> li = new ArrayList<>();
        preorderTraversal(root, li);
        return li;
    }
}
