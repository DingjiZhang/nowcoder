package leetCode100.myBinaryTree;

public class diameterOfBinaryTree {

    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 以节点A为根的路径所经过的最大节点数：左子树深度+右子树深度+1（自己）
        // 求所有节点的最大节点数
        // 路径长度为节点数 - 1
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r + 1);

        return Math.max(l, r) + 1; // 返回以该节点为根的子树深度（含自己）
    }
}
