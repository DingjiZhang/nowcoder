package leetCode100.myBinaryTree;

public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right; // p q 都不在左子树，那么右孩子就是
        if (right == null) return left;
        return root;   // 左右都没有（pq分居两侧），当前就是
    }
}
