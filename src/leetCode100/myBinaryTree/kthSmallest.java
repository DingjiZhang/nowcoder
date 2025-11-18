package leetCode100.myBinaryTree;

public class kthSmallest {

    TreeNode ans;
    int index; // 计数器

    // 中序遍历
    public int kthSmallest(TreeNode root, int k) {
        ans = null;
        index = 1;
        if (k != 0 && root != null) {
            dfs(root, k);
        }

        if (ans != null) return ans.val;

        return -1;
    }

    private void dfs(TreeNode node, int k) {
        if (ans == null) {
            if (node.left != null) {
                dfs(node.left, k);
            }
            //
            if (index == k) {
                ans = node;
            }
            index++;

            if (node.right != null) {
                dfs(node.right, k);
            }
        }
    }
}
