package nowCoder.myTree;

public class BST_LCA {
    /* p q 都 < node, 往左找
    /* p q 都 > node, 往右找
    /* p q 一左一右, 当前node就是
    * */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        int a = Math.min(p, q);
        int b = Math.max(p, q);
        TreeNode cur = root;
        while (cur != null) {
            if (b < cur.val) {
                cur = cur.left;
            } else if (cur.val < a) {
                cur = cur.right;
            } else {
                return cur.val;
            }
        }
        return -1;
    }
}
