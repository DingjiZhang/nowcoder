package leetCode100.myBinaryTree;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        // LRN
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        return root;
    }
}
