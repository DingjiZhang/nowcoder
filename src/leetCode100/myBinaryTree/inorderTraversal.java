package leetCode100.myBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    // LNR
    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) return;
        dfs(list, node.left);
        list.add(node.val);
        dfs(list, node.right);
    }
}
