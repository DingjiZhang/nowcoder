package nowCoder.myTree;

public class Convert {
    private TreeNode ans; // 最终链表头部
    private TreeNode moveNode; // 链表尾部

    private void dfs(TreeNode node) {
        if (node.left != null) {
            dfs(node.left);
        }
        /* 操作空间：中序到达时刻，即第二次遍历到该节点的时刻 */
        if (ans == null) { // 到达最左叶子
            ans = node;
            moveNode = node;
        } else {
            // 一般处理 - 添加边，修改边
            moveNode.right = node; // move的右后
            node.left = moveNode; // node的左前

            moveNode = node; // 更新尾部节点
        }
        if (node.right != null) {
            dfs(node.right);
        }

    }

    // 左前右继
    // 1. LNR 中序遍历
    // 2. 操作空间：中序时刻：左前右后连起来
    // 3. 二叉树指向的变动
    // 尾插法
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ans = null;
        moveNode = null;
        dfs(pRootOfTree);
        return ans;
    }
}
