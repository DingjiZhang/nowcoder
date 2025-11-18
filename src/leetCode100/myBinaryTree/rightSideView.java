package leetCode100.myBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class rightSideView {

    // DFS
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    // depth表示当前所在层数 NRL
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        // 记录第一个节点
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        //
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }

    // BFS
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size(); // 当前层节点数

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // 当前层最后一个节点加入
                if (i == size - 1) ans.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return ans;
    }

}
