package nowCoder.myTree;

public class isSymmetrical {

    /*“成对比较”就行：对称 ⇔ 左子树与右子树镜像相等。
    规则：(L.val == R.val) && isMirror(L.left, R.right) && isMirror(L.right, R.left)。*/
    private boolean isMirror(TreeNode a, TreeNode b) {
        // 终止条件
        if (a == null && b == null) return true;
        // 列出不是镜像的情况
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isMirror(pRoot.left, pRoot.right);
    }
}
