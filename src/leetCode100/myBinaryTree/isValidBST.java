package leetCode100.myBinaryTree;

public class isValidBST {

    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        // 中序遍历，检查curr > prev的值即可
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        // L
        if (!inorder(node.left)) return false;

        // N cur
        if (prev != null && node.val <= prev) return false; // 判断是否严格递增
        prev = node.val;  // 更新前一个值

        return inorder(node.right); // R
    }
}
