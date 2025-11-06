package nowCoder.myTree;

public class IsBalanced {
    boolean ans = true;

    public boolean IsBalanced_Solution(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        TreeDepth(pRoot);
        return ans;
    }

    private int TreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (ans) {
            int leftDepth = TreeDepth(node.left);
            int rightDepth = TreeDepth(node.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                ans = false;
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return 0; //瞎返回的 因为ans = false
    }
}
