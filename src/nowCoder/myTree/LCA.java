package nowCoder.myTree;

public class LCA {
    /* LRN
    对每个结点 x：
	•	递归得到：左子树里是否包含目标、右子树里是否包含目标；
	•	再在后序时刻把三者相加：
cnt = (左是否有) + (右是否有) + (x 是否就是 o1 或 o2)
若 cnt >= 2，第一次满足该条件的结点就是最近公共祖先；
	•	向上只需返回“这一侧是否包含目标”（布尔/0或1），供祖先继续合并。

        这就是“后序合并”的典型用法：孩子先算好，父亲在后序位置做决定。
     * */
    private TreeNode ans = null;
    private int a, b;

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        a = o1;
        b = o2;
        dfs(root);
        return ans == null ? -1 : ans.val;
    }

    /**
     * 判断node子树是否含 o1 or o2 (0/1)；如果L+R+当前node >=2 则表示node就是要找的节点
     *
     * @param node 当前节点
     * @return 0表示没有，1表示有
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        int mid = (node.val == a || node.val == b) ? 1 : 0;

        // 后序到达时刻
        int cnt = left + right + mid;
        if (ans == null && cnt >= 2) ans = node; // 第一次同时命中两侧/自己，即LCA

        return cnt > 0 ? 1 : 0; // 往上告诉祖先，这一侧有没有目标
    }
}
