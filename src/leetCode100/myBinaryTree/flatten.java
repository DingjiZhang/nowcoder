package leetCode100.myBinaryTree;

public class flatten {

    // 解法一：找到左子树最右的节点，将根的右子树接到其右节点
    // 再将左子树变成右子树，继续下一个
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right; // 为空直接下一个
            } else {
                // 左子树最右节点
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                //
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                //
                root = root.right;
            }
        }
    }

    // 右左根，当前指针指向上一个节点
    TreeNode pre = null;

    public void flattenRLN(TreeNode root) {
        if (root == null) return;

        flattenRLN(root.right);
        flattenRLN(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
