package nowCoder.myTree;

public class Mirror {
    // 从最底层开始，以层为单位交换
    // 先遍历孩子再父母 -> 后序遍历 LRN
    public TreeNode Mirror(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                Mirror(node.left);
            }
            if (node.right != null) {
                Mirror(node.right);
            }
            // 后序的操作点
            // 交换node节点的左右孩子
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }
}
