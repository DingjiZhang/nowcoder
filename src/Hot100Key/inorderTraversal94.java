package Hot100Key;

import leetCode100.myList.ListNode;

import java.util.*;

public class inorderTraversal94 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    // 方法2：栈
    public List<Integer> inorderTravesal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) return ans;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 1.当前节点为空，说明左边还有
            if (curr != null) {
                // 压栈左节点
                stack.push(curr);
                curr = curr.left;
            } else { // 2. 当前节点为空，说明当前节点已到最左侧
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }

}
