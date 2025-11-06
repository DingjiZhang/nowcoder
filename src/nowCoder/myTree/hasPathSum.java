package nowCoder.myTree;

public class hasPathSum {
    private boolean found = false;

    private void solve(TreeNode node, int sum, int currentSum) {
        if (node != null) {
            currentSum += node.val;

            if (node.left == null && node.right == null) {
                if (currentSum == sum) {
                    found = true;
                    return;
                }
            } else {
                solve(node.left, sum, currentSum);
                solve(node.right, sum, currentSum);
            }
            // 回溯
            currentSum -= node.val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        solve(root, sum, 0);
        return found;
    }
}
