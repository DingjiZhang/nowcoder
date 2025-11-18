package leetCode100.myBinaryTree;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // end
        if (left == null && right == null) return true;

        if (left == null || right == null || left.val != right.val) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
