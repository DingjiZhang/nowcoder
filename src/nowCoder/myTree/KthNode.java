package nowCoder.myTree;

public class KthNode {
    private TreeNode ans;
    private int index; // 中序的第几个结果

    public int KthNode(TreeNode proot, int k) {
        index = 1;
        ans = null;
        if (k != 0 && proot != null) {
            solve(proot, k);
        }

        if (ans != null) {
            return ans.val;
        }
        return -1;
    }

    // LNR:（操作点在中间）升序
    // RNL:（操作点在中间）降序
    private void solve(TreeNode node, int k) {
        if (ans == null) {
            if (node.left != null) {
                solve(node.left, k);
            }
            // 中序操作点
            if (index == k) {
                ans = node;
            }
            index++;

            if (node.right != null) {
                solve(node.right, k);
            }
        }
    }
}
